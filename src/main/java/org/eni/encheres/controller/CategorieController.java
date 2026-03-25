package org.eni.encheres.controller;


import org.eni.encheres.bo.Categorie;
import org.eni.encheres.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/encheres/categorie")
public class CategorieController {

    @Autowired
    private  CategorieService categorieService;




    @GetMapping
    public String getCategorie(Model model){
        // 1 - j'ajoute dans mon modèle l'attribut "categorie" qui va servir à générer les lignes de la table HTML de mon template
        // pour cela : j'utilse la méthode consulterCategorie() de mon service
        model.addAttribute("categories", categorieService.consulterCategorie());

        // 2 - afin de pouvoir utiliser th:object sur ùmon formulaire d'ajout de genre
        // j'initialise mon modèle avec un attribut "nouvelleCategorie" qui contient un objet vide Categorie (que le formulaire va remplir)
        model.addAttribute("categorie", new Categorie());

        // 3 - retourne le template "categorie.html" qui contient la table HTML qui affiche les categories ainsi que le formulaire de création de categories
        return "page/categorie";
    }

    /**
     * Méthode appelée lorsque je valide le formulaire (requête POST) de l'url : http://localhost:8080/categories :
     * - 1 : je délègue au service la création de la catégorie
     * - 2 : je redirige sur la page qui liste les categories (redirect:/genres)
     */
    @PostMapping
    public String postCategorie(Categorie categorie){
        // 1 : je délègue au service la création du genre
        categorieService.creerCategorie(categorie);

        // 2 : je redirige sur la page qui liste les categories (redirect:/categorie)
        return "redirect:/encheres/categorie";
    }

    /**
     * Méthode appelée lorsque je clique sur un bouton de suppression de categorie (requête POST)
     * qui valide le formulaire  <form class="inline-form" action="/categorie/supprimer" method="post">
     *     Ce que fait la méthode :
     * - 1 : je délègue au service la suppression de la categorie
     * - 2 : je redirige sur la page qui liste les categories (redirect:/categorie)
     */
    @PostMapping("/supprimer")
    public String supprimerCategorie(int idAsupprimer) {
        // 1 : je délègue au service la suppression du genre
        categorieService.supprimerCategorie(idAsupprimer);

        // 2 : je redirige sur la page qui liste les genres (redirect:/genres)
        return "redirect:/encheres/categorie";
    }



}
