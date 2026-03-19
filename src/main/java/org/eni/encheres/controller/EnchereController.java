package org.eni.encheres.controller;


import org.eni.encheres.bo.Enchere;
import org.eni.encheres.dal.ArticleVenduDao;
import org.eni.encheres.dal.EnchereDao;
import org.eni.encheres.service.ArticleVenduService;
import org.eni.encheres.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/encheres")

public class EnchereController {
    @Autowired
    private EnchereService enchereService;
    @Autowired
    private ArticleVenduService articleVenduService;

    @ModelAttribute("encheres")
    public List<Enchere> getAttributeModelEncheres() {
        return enchereService.ListEncheres();
    }

    @GetMapping
    public String getEncheres(){
        return "index";
    }


    @GetMapping("/nouvelleVente")
    public String nouvelleVente(Model model){
    model.addAttribute("enchere",new Enchere());
        return "page/nouvelleVente";
    }
    @PostMapping("/nouvelleVente")
    public String getNouvelleVente(@PathVariable String nouvelleVente, Model model){
        model.addAttribute("nouvelleVente", articleVenduService.listArticlesVendu().get(Integer.parseInt(nouvelleVente)));
        return "page/nouvelleVente";
        }


    @GetMapping("/{id}/detail")
    public String detail(@PathVariable("id") int id){
        enchereService.consulterEncheresParId(id);
        return "detail";
    }

    /**
 *
 *
 *
 *
 * TODO
 *
 * 1.
 * un getEncheres
 * page index.html
 *
 * 2.
 * un getVentes @GetMapping("nouvelleVente")
 * page nouvelleVente.html
 *
 *3. un getDetail @GetMapping("/{id}/detail")
 * page detail.html
 *
 *
 *
 */

}
