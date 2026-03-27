package org.eni.encheres.controller;

import lombok.AllArgsConstructor;
import org.eni.encheres.bo.Categorie;
import org.eni.encheres.bo.dto.ArticleDto;
import org.eni.encheres.service.ArticleVenduService;
import org.eni.encheres.service.CategorieService;
import org.eni.encheres.service.FileArticleService;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/encheres")
public class ArticleVenduController {

    private CategorieService categorieService;
    private ArticleVenduService articleVenduService;
    private UtilisateurService utilisateurService;
    private FileArticleService fileArticleService;

    @ModelAttribute("categories")
    public List<Categorie> getAttributeModelCategories() {
        return categorieService.consulterCategorie();
    }

    @GetMapping("/profil/{id}/nouvelleVente")
    public String getNouvelleVente(@PathVariable int id, Model model){
        model.addAttribute("dateMinDebut", LocalDate.now());
        model.addAttribute("dateMinFin", LocalDate.now().plusDays(1));
        model.addAttribute("utilisateur", utilisateurService.getUtilisateurById(id));
        model.addAttribute("articleDto",new ArticleDto());

        return "page/nouvelleVente";
    }

    @PostMapping("/profil/{id}/nouvelleVente")
    public String postNouvelleVente(@PathVariable int id, @RequestParam("image") MultipartFile file, ArticleDto articleDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {
//        if (bindingResult.hasErrors()) {
//            return "index";
//        }
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
        }

        if (!file.isEmpty()) {
            String imagePath = fileArticleService.save(file);
            articleDto.setImagePath(imagePath);
        }

        /**
         * S'assurer que la date du début de l'enchere ne soit pas inférieur à la date d'aujourd'hui
         */
        if (articleDto.getDateDebutEncheres().isBefore(LocalDate.now())) {
            redirectAttributes.addFlashAttribute("messageErreur", "La date du début d'enchere ne doit pas être inférieur à aujourd'hui.");
            return "redirect:/encheres/profil/" + id + "/nouvelleVente";
        }

        /**
         * S'assurer que la date de fin de l'enchere soit supérieur à la date d'aujourd'hui
         */
        if (articleDto.getDateFinEncheres().isBefore(LocalDate.now().plusDays(1))) {
            redirectAttributes.addFlashAttribute("messageErreur", "La date de fin de l'enchere doit être supérieur à aujourd'hui.");
            return "redirect:/encheres/profil/" + id + "/nouvelleVente";
        }

        if (articleDto.getPrixInitial()<10) {
            redirectAttributes.addFlashAttribute("messageErreur", "Le prix initial doit être supérieur à 10 crédits.");
            return "redirect:/encheres/profil/" + id + "/nouvelleVente";
        }

        /**
         * Bien penser à modifier le vendeur avant de vérifier les champs vides du RETRAIT
         */
        articleDto.setVendeur(utilisateurService.getUtilisateurById(id));

        // Si les champs rue/code_postal/ville sont vides, mettre l'adresse du vendeur
        if (articleDto.getRue().isEmpty()) {articleDto.setRue(articleDto.getVendeur().getRue());}
        if (articleDto.getCode_postal().isEmpty()) {articleDto.setCode_postal(articleDto.getVendeur().getCodePostal());}
        if (articleDto.getVille().isEmpty()) {articleDto.setVille(articleDto.getVendeur().getVille());}

        articleVenduService.creerArticleVendu(articleDto);
        return "redirect:/";
    }

}
