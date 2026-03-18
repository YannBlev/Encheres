package org.eni.encheres.controller;


import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.dal.UtilisateurDao;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


                // TODO mettre correctement les bonnes adresses de redirection :

@Controller
@RequestMapping("/MonProfil")
public class UtilisateurController {

    @Autowired
    private final UtilisateurService utilisateurService;
    UtilisateurDao utilisateurDao;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }


    @GetMapping("")
    public String utilisateur(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "page/profil";
    }

    @PostMapping("/profil")// Création Utilisateur
    public String creerUtilisateur(Utilisateur utilisateur) {
        utilisateurService.creerUtilisateur(utilisateur);
        return "redirect:/Profil";
    }

    @PostMapping("/delete") //Supprimer Utilisateur dans son menu utilisateur
    public String suppressionutilisateur(Utilisateur idUtilisateurASupprimer) {
        utilisateurService.supprimerUtilisateur(idUtilisateurASupprimer);
        return "redirect:/MonProfil/profil";
    }

    @PostMapping("getById")
    public String getUtilisateurById(Utilisateur utilisateur) {
        utilisateurService.getUtilisateurById(utilisateur.getId());
        return "redirect:/utilisateur";
    }


    @PostMapping("/list")
    public List<Utilisateur>listerUtilisateur() {
        utilisateurService.listerUtilisateurs();
        return utilisateurService.listerUtilisateurs();
    }

    @PostMapping("/update") // menu utilisateur
    public String updateUtilisateur(Utilisateur utilisateur) {
        utilisateurService.updateUtilisateur(utilisateur);
        return "redirect:/MonProfil/profil";
    }

}
