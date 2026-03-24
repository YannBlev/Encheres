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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @GetMapping("/{id}/nouvelleVente")
    public String getNouvelleVente(@PathVariable int id, Model model){
        model.addAttribute("utilisateur", utilisateurService.getUtilisateurById(id));
        model.addAttribute("articleDto",new ArticleDto());

        return "page/nouvelleVente";
    }

    @PostMapping("/{id}/nouvelleVente")
    public String postNouvelleVente(@PathVariable int id, @RequestParam("image") MultipartFile file, ArticleDto articleDto, BindingResult bindingResult) throws IOException {
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
