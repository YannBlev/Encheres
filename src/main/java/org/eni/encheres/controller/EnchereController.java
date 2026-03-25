package org.eni.encheres.controller;


import lombok.AllArgsConstructor;
import org.eni.encheres.bo.*;
import org.eni.encheres.dal.ArticleVenduDao;
import org.eni.encheres.dal.EnchereDao;
import org.eni.encheres.security.UtilisateurSpringSecurity;
import org.eni.encheres.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/encheres")
public class EnchereController {

    private final UtilisateurService utilisateurService;
    private final EnchereService enchereService;
    private ArticleVenduService articleVenduService;
    private RetraitService retraitService;
    private CategorieService categorieService;

    @ModelAttribute("articles")
    public List<ArticleVendu> getAttributeModelArticles() {
        return articleVenduService.listArticlesVendu();
    }

    @ModelAttribute("categories")
    public List<Categorie> getAttributeModelCategories() {
        return categorieService.consulterCategorie();
    }

    @GetMapping
    public String getEncheres(){
        return "index";
    }

    @GetMapping("/article/{id}")
    public String detail(@PathVariable("id") int id, Model model){


        ArticleVendu article = articleVenduService.consulterArticleVendu(id);
        Retrait retrait = retraitService.consulterAdresseById(id);
        model.addAttribute("article", article);
        model.addAttribute("retrait", retrait);
        return "page/detailVente";
    }

    @PostMapping("/article/{id}/encherir")
    public String postEncherir(@PathVariable("id") int id, @AuthenticationPrincipal UtilisateurSpringSecurity utilisateurConnecte, @RequestParam("proposition") int proposition){

        Utilisateur utilisateur = utilisateurConnecte.getUtilisateur();
        ArticleVendu article = articleVenduService.consulterArticleVendu(id);

        if (enchereService.peutEncherir(utilisateur, article, proposition)) {
            Enchere enchere = new Enchere();
            enchere.setUtilisateur(utilisateur);
            enchere.setArticle(article);
            enchere.setMontantEnchere(proposition);
            enchere.setDateEnchere(LocalDate.now());
            enchereService.creerEnchere(enchere);
        }
        return "redirect:/" ;
    }


}
