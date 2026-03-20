package org.eni.encheres.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.wrapper.ArticleRetraitWrapper;
import org.eni.encheres.service.ArticleVenduService;
import org.eni.encheres.service.CategorieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ArticleVenduController {

    private CategorieService categorieService;
    private ArticleVenduService articleVenduService;

    @GetMapping("/encheres/nouvelleVente")
    public String nouvelleVente(Model model){
        model.addAttribute("categories", categorieService.consulterCategorie());
        model.addAttribute("article",new ArticleVendu());

        return "page/nouvelleVente";
    }

    @PostMapping("/encheres/nouvelleVente")
    public String getNouvelleVente(ArticleRetraitWrapper wrapper, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        articleVenduService.creerArticleVendu(wrapper.getArticle());
        return "redirect:/encheres";
    }

}
