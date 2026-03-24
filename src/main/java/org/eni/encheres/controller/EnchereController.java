package org.eni.encheres.controller;


import lombok.AllArgsConstructor;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Enchere;
import org.eni.encheres.bo.Retrait;
import org.eni.encheres.dal.ArticleVenduDao;
import org.eni.encheres.dal.EnchereDao;
import org.eni.encheres.service.ArticleVenduService;
import org.eni.encheres.service.CategorieService;
import org.eni.encheres.service.EnchereService;
import org.eni.encheres.service.RetraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping()
public class EnchereController {

    private ArticleVenduService articleVenduService;
    private RetraitService retraitService;

    @ModelAttribute("articles")
    public List<ArticleVendu> getAttributeModelArticles() {
        return articleVenduService.listArticlesVendu();
    }

    @GetMapping
    public String getEncheres(){
        return "index";
    }


    @GetMapping("/{id}")
    public String detail(@PathVariable("id") int id, Model model){
        ArticleVendu article = articleVenduService.consulterArticleVendu(id);
        Retrait retrait = retraitService.consulterAdresseById(id);
        model.addAttribute("article", article);
        model.addAttribute("retrait", retrait);
        return "page/detailVente";
    }

    @PostMapping("/{id}/encherir")
    public String postEncherir(@PathVariable("id") int id){

        return "redirect:/encheres" ;
    }


}
