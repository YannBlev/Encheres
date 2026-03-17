package org.eni.encheres.controller;


import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;


                // TODO mettre correctement les bonnes adresses de redirection :

@Controller
// @RequestMapping
@Autowired
public class UtilisateurController {
    UtilisateurService utilisateurService;

    @GetMapping
    public String utilisateur(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateur";
    }

    @PostMapping("/create")// Création Utilisateur
    public String creerUtilisateur(Utilisateur utilisateur) {
        utilisateurService.creerUtilisateur(utilisateur);
        return "redirect:/utilisateur";
    }

    @PostMapping("/delete") //Supprimer Utilisateur
    public String suppressionutilisateur(Utilisateur idUtilisateurASupprimer) {
        utilisateurService.supprimerUtilisateur(idUtilisateurASupprimer);
        return "redirect:/utilisateur";
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

    @PostMapping("/update")
    public String updateUtilisateur(Utilisateur utilisateur) {
        utilisateurService.updateUtilisateur(utilisateur);
        return "redirect:/utilisateur";
    }

}
