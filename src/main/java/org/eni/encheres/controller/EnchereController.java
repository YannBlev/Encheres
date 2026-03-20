package org.eni.encheres.controller;


import lombok.AllArgsConstructor;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Enchere;
import org.eni.encheres.dal.ArticleVenduDao;
import org.eni.encheres.dal.EnchereDao;
import org.eni.encheres.service.ArticleVenduService;
import org.eni.encheres.service.CategorieService;
import org.eni.encheres.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/encheres")
public class EnchereController {

    private ArticleVenduService articleVenduService;

    @ModelAttribute("articles")
    public List<ArticleVendu> getAttributeModelArticles() {
        return articleVenduService.listArticlesVendu();
    }

    @GetMapping
    public String getEncheres(){
        return "index";
    }


    @GetMapping("/{id}/detail")
    public String detail(@PathVariable("id") int id){
        articleVenduService.consulterArticleVendu(id);
        return "detail";
    }

}
