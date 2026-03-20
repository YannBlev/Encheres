package org.eni.encheres.controller;

import lombok.AllArgsConstructor;
import org.eni.encheres.dto.ArticleDto;
import org.eni.encheres.service.ArticleVenduService;
import org.eni.encheres.service.CategorieService;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ArticleVenduController {

    private CategorieService categorieService;
    private ArticleVenduService articleVenduService;
    private UtilisateurService utilisateurService;

    @GetMapping("/encheres/{pseudo}/nouvelleVente")
    public String getNouvelleVente(@PathVariable String pseudo, Model model){
        model.addAttribute("utilisateur", utilisateurService.listerUtilisateurs().stream().filter(u -> u.getPseudo().equals(pseudo)).findFirst().orElse(null));
        model.addAttribute("categories", categorieService.consulterCategorie());
        model.addAttribute("articleDto",new ArticleDto());

        return "page/nouvelleVente";
    }

    @PostMapping("/encheres/{pseudo}/nouvelleVente")
    public String postNouvelleVente(@PathVariable String pseudo, ArticleDto articleDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "index";
//        }
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
        }

        articleDto.setVendeur(utilisateurService.listerUtilisateurs().stream().filter(u -> u.getPseudo().equals(pseudo)).findFirst().orElse(null));
        articleVenduService.creerArticleVendu(articleDto);
        return "redirect:/encheres";
    }

}
