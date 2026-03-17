package org.eni.encheres.controller;


import org.eni.encheres.bo.Enchere;
import org.eni.encheres.dal.EnchereDao;
import org.eni.encheres.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("encheres")
public class EnchereController {
    @Autowired
    private final EnchereService enchereService;
    EnchereDao enchereDao;

    public EnchereController(EnchereService enchereService) {
        this.enchereService = enchereService;
    }

    @ModelAttribute
    public List<Enchere> getEncheres() {
        return enchereService.ListEncheres();
    }

    public String encheres(Model model){
        model.addAttribute("enchereDao",enchereDao);
        return "encheres";
    }
    @GetMapping("/index")
    public String index(){
        enchereService.ListEncheres();
        return "index";
    }
    @GetMapping("/NouvelleVente")
    public String nouvelleVente(){
        enchereService.creerEnchere(null);
        return "nouvelleVente";
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
