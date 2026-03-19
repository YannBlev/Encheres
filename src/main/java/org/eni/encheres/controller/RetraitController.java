package org.eni.encheres.controller;


import org.eni.encheres.bo.Retrait;

import org.eni.encheres.service.RetraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/retrait")
public class RetraitController {

    @Autowired
    private RetraitService retraitService;

    @GetMapping
    public String getAdresse(Model model) {
        // 1 - j'ajoute dans mon modèle l'attribut "categorie" qui va servir à générer les lignes de la table HTML de mon template
        // pour cela : j'utilse la méthode consulterCategorie() de mon service
        model.addAttribute("retraits", retraitService.ListAdresse());
        model.addAttribute("retrait", new Retrait());

        return "retrait";
    }

    @PostMapping
    public String postAdresse(Retrait retrait) {
        // 1 : je délègue au service la création du genre
        retraitService.creerAdresse(retrait);

        // 2 : je redirige sur la page qui liste les genres (redirect:/genres)
        return "redirect:/retrait";

    }

    @PostMapping("/supprimer")
    public String supprimerAdresse(int IdAdresseASupprimer){
        // 1 : je délègue au service la suppression de l'adresse
        retraitService.supprimerAdresse(IdAdresseASupprimer);

        // 2 : je redirige sur la page qui liste les adresses (redirect:/adresses)
        return "redirect:/retrait";
    }






}
