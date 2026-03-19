package org.eni.encheres.controller;


import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// TODO mettre correctement les bonnes adresses de redirection :

@Controller
@RequestMapping("/profil")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;


    @GetMapping()
    public String utilisateur(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "profilUtilisateur";
    }

    @PostMapping()// Création Utilisateur
    public String creerUtilisateur(Utilisateur utilisateur) {
        utilisateurService.creerUtilisateur(utilisateur);
        return "redirect:/profil";
    }

    @PostMapping("/delete") //Supprimer Utilisateur dans son menu utilisateur
    public String suppressionutilisateur(Utilisateur idUtilisateurASupprimer) {
        utilisateurService.supprimerUtilisateur(idUtilisateurASupprimer);
        return "redirect:/profil";
    }

    @GetMapping("/nouveauProfil")
    public String nouveauProfil(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "page/nouveauProfil";
    }

    @PostMapping("/nouveauProfil")
    public String ajouterProfil(Utilisateur utilisateur) {
        utilisateurService.creerUtilisateur(utilisateur);
        return "redirect:/profil";
    }

}
