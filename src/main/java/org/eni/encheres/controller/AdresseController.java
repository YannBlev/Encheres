package org.eni.encheres.controller;


import org.eni.encheres.bo.Adresse;
import org.eni.encheres.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adresse")
public class AdresseController {

    @Autowired
    private AdresseService adresseService;

    @GetMapping
    public String getAdresse(Model model) {
        // 1 - j'ajoute dans mon modèle l'attribut "categorie" qui va servir à générer les lignes de la table HTML de mon template
        // pour cela : j'utilse la méthode consulterCategorie() de mon service
        model.addAttribute("adresses", adresseService.ListAdresse());
        model.addAttribute("adresse", new Adresse());

        return "adresses";
    }








}
