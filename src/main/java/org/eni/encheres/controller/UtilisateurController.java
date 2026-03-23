package org.eni.encheres.controller;


import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.security.UtilisateurSpringSecurity;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    public String getUtilisateur(@PathVariable String pseudo, @AuthenticationPrincipal UtilisateurSpringSecurity utilisateurConnecte, Model model ) {
        Utilisateur utilisateur = utilisateurService.listerUtilisateurs().stream().filter(u -> u.getPseudo().equals(pseudo)).findFirst().orElse(null);
        String pseudo1 = utilisateurConnecte.getPseudo();
        model.addAttribute("pseudo1", pseudo1);
//        if (utilisateur == null || pseudo1 == null) {
//            return "redirect:/encheres"; // Ou une page d'erreur 404 personnalisée
//        }
        model.addAttribute("utilisateur", utilisateur);

        return "page/profilUtilisateur";


    }

    @PostMapping("/profil/delete") //Supprimer Utilisateur dans son menu utilisateur
    public String suppressionUtilisateur(@RequestParam("idUtilisateurASupprimer")Utilisateur idUtilisateurASupprimer) {
        utilisateurService.supprimerUtilisateur(idUtilisateurASupprimer);
        return "redirect:/login";
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
        return "redirect:../login";
    }

    @GetMapping("/profil")
    public String monProfil(Model model, Utilisateur Utilisateur) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(Integer.parseInt(Utilisateur.getPseudo()));
        model.addAttribute("utilisateur", utilisateur);
        return "page/profilUtilisateur";
    }

    @GetMapping("/profil/{pseudo}/modifier")
    public String afficherModification(@PathVariable String pseudo, @AuthenticationPrincipal UtilisateurSpringSecurity utilisateurConnecte, Model model ) {
        Utilisateur utilisateur = utilisateurService.listerUtilisateurs().stream().filter(u -> u.getPseudo().equals(pseudo)).findFirst().orElse(null);
        String pseudo1 = utilisateurConnecte.getPseudo();
        model.addAttribute("pseudo1", pseudo1);
//        if (utilisateur == null || pseudo1 == null) {
//            return "redirect:/encheres"; // Ou une page d'erreur 404 personnalisée
//        }
        model.addAttribute("utilisateur", utilisateur);

        return "page/nouveauProfil";


    }
    @PostMapping("/profil/{pseudo}/modifier")
    public String modifierProfil(
            @PathVariable String pseudo,
            @AuthenticationPrincipal UtilisateurSpringSecurity utilisateurConnecte,
            Utilisateur utilisateur,
            Model model) {

        if (utilisateurConnecte == null) {
            return "redirect:/login";
        }

        if (!utilisateurConnecte.getPseudo().equals(pseudo)) {
            return "redirect:/encheres";
        }

        utilisateurService.modifierUtilisateur(utilisateur);
        return "redirect:/profilUtilisateur/" + pseudo;
    }
}
