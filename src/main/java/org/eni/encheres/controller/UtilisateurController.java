package org.eni.encheres.controller;


import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// TODO mettre correctement les bonnes adresses de redirection :

@Controller
@RequestMapping
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/profils")
    public String getUtilisateurs(Model model) {
        model.addAttribute("utilisateurs", utilisateurService.listerUtilisateurs());
        return "page/profils";
    }

    @GetMapping("/profil/{pseudo}")
    public String getUtilisateur(@PathVariable String pseudo, Model model) {
        model.addAttribute("utilisateur", utilisateurService.listerUtilisateurs().stream().filter(u -> u.getPseudo().equals(pseudo)).findFirst().orElse(null));
        return "page/profilUtilisateur";
    }

    @PostMapping("/profil/inscription")// Création Utilisateur
    public String creerUtilisateur(Utilisateur utilisateur) {
        utilisateurService.creerUtilisateur(utilisateur);
        return "redirect:/encheres";
    }

    @PostMapping("/profil/delete") //Supprimer Utilisateur dans son menu utilisateur
    public String suppressionUtilisateur(Utilisateur idUtilisateurASupprimer) {
        utilisateurService.supprimerUtilisateur(idUtilisateurASupprimer);
        return "redirect:/profil";
    }

    // TODO UtilisateurDTO
    @GetMapping("/profil/nouveauProfil")
    public String nouveauProfil(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "page/nouveauProfil";
    }

    //TODO UtilisateurDTO
    @PostMapping("/profil/nouveauProfil")
    public String ajouterProfil(Utilisateur utilisateur) {
        utilisateurService.creerUtilisateur(utilisateur);
        return "redirect:page/encheres";
    }

}
