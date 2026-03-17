//package org.eni.encheres.controller;
//
//
//import org.eni.encheres.bo.Utilisateur;
//import org.eni.encheres.service.UtilisateurService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import java.util.List;
//
//
//                // TODO mettre correctement les bonnes adresses de redirection :
//
//@Controller
//// @RequestMapping
//public class UtilisateurController {
//    UtilisateurService utilisateurService;
//
//    @GetMapping
//    public String utilisateur(Model model) {
//        model.addAttribute("utilisateur", new Utilisateur());
//        return "utilisateur";
//    }
//
//    @PostMapping// Création Utilisateur
//    public String creerUtilisateur(Utilisateur Utilisateur) {
//        utilisateurService.creerUtilisateur(Utilisateur);
//        return "redirect:/utilisateur";
//    }
//
//    @PostMapping //Supprimer Utilisateur
//    public String suppressionutilisateur(Utilisateur idUtilisateurASupprimer) {
//        utilisateurService.supprimerUtilisateur(idUtilisateurASupprimer);
//        return "redirect:/utilisateur";
//    }
//
//    @PostMapping
//    public String getUtilisateurById(Utilisateur utilisateur) {
//        utilisateurService.getUtilisateurById(utilisateur.getId());
//        return "redirect:/utilisateur";
//    }
//
//
//    @PostMapping
//    public List<Utilisateur>listerUtilisateur() {
//        utilisateurService.listerUtilisateurs();
//        return utilisateurService.listerUtilisateurs();
//    }
//
//    @PostMapping
//    public String updateUtilisateur(Utilisateur utilisateur) {
//        utilisateurService.updateUtilisateur(utilisateur);
//        return "redirect:/utilisateur";
//    }
//
//
////    @PostMapping
////    public String getUtilisateurByEmail(Utilisateur utilisateur) {
////        utilisateurService.getUtilisateurByEmail(utilisateur.getEmail());
////        return "redirect:/utilisateur";
////    }
//
//}
