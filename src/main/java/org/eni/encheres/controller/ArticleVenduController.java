package org.eni.encheres.controller;

import lombok.AllArgsConstructor;
import org.eni.encheres.bo.dto.ArticleDto;
import org.eni.encheres.service.ArticleVenduService;
import org.eni.encheres.service.CategorieService;
import org.eni.encheres.service.FileArticleService;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@AllArgsConstructor
public class ArticleVenduController {

    private CategorieService categorieService;
    private ArticleVenduService articleVenduService;
    private UtilisateurService utilisateurService;
    private FileArticleService fileArticleService;

    @GetMapping("/encheres/{pseudo}/nouvelleVente")
    public String getNouvelleVente(@PathVariable String pseudo, Model model){
        model.addAttribute("utilisateur", utilisateurService.listerUtilisateurs().stream().filter(u -> u.getPseudo().equals(pseudo)).findFirst().orElse(null));
        model.addAttribute("categories", categorieService.consulterCategorie());
        model.addAttribute("articleDto",new ArticleDto());

        return "page/nouvelleVente";
    }

    @PostMapping("/encheres/{pseudo}/nouvelleVente")
    public String postNouvelleVente(@PathVariable String pseudo, @RequestParam("image") MultipartFile file, ArticleDto articleDto, BindingResult bindingResult) throws IOException {
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
        articleDto.setVendeur(utilisateurService.listerUtilisateurs().stream().filter(u -> u.getPseudo().equals(pseudo)).findFirst().orElse(null));

        if (articleDto.getRue().isEmpty()) {articleDto.setRue(articleDto.getVendeur().getRue());}

        if (articleDto.getCode_postal().isEmpty()) {articleDto.setCode_postal(articleDto.getVendeur().getCodePostal());}

        if (articleDto.getVille().isEmpty()) {articleDto.setVille(articleDto.getVendeur().getVille());}



        articleVenduService.creerArticleVendu(articleDto);
        return "redirect:/encheres";
    }

}
