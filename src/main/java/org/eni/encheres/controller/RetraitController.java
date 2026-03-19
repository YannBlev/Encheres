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

        return "page/retrait";
    }

    @PostMapping
    public String postAdresse(Retrait retrait) {
        // 1 : je délègue au service la création du genre/*
        // PENSER A SORTIR ET SUPPRIMER LA DATABASE POUR POUVOIR LA CREER
        //*/
        //CREATE DATABASE ENCHERES_ORG;
        //-- ENTRER DANS LA DATABASE AFIN D'Y CREER LES TABLES ET CONTRAINTES
        //USE ENCHERES_ORG;
        //CREATE TABLE CATEGORIE (
        //    id_categorie   INTEGER IDENTITY(1,1) NOT NULL,
        //    libelle        VARCHAR(255) NOT NULL
        //)
        //ALTER TABLE CATEGORIE ADD constraint categorie_pk PRIMARY KEY (id_categorie);
        //CREATE TABLE ENCHERE (
        // id_enchere  INTEGER IDENTITY NOT NULL,
        //    id_enchereur INTEGER NOT NULL,
        //    id_article  INTEGER NOT NULL,
        //    date_enchere DATETIME NOT NULL,
        // montant_enchere INTEGER NOT NULL
        //)
        //ALTER TABLE ENCHERE ADD constraint enchere_pk PRIMARY KEY (id_enchere);
        //CREATE TABLE RETRAIT (
        // id_article  INTEGER NOT NULL,
        //    rue              VARCHAR(30) NOT NULL,
        //    code_postal      VARCHAR(15) NOT NULL,
        //    ville            VARCHAR(30) NOT NULL
        //)
        //ALTER TABLE RETRAIT ADD constraint retrait_pk PRIMARY KEY  (id_article);
        //CREATE TABLE UTILISATEUR (
        //    id_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
        //    pseudo           VARCHAR(255) UNIQUE NOT NULL,
        //    nom              VARCHAR(255) NOT NULL,
        //    prenom           VARCHAR(255) NOT NULL,
        //    email            VARCHAR(255) UNIQUE NOT NULL,
        //    telephone        VARCHAR(15),
        //    rue              VARCHAR(255) NOT NULL,
        //    code_postal      VARCHAR(10) NOT NULL,
        //    ville            VARCHAR(255) NOT NULL,
        //    mot_de_passe     VARCHAR(255) NOT NULL,
        //    credit           INTEGER NOT NULL,
        //    administrateur   BIT NOT NULL
        //)
        //ALTER TABLE UTILISATEUR ADD constraint utilisateur_pk PRIMARY KEY (id_utilisateur);
        //CREATE TABLE ARTICLE (
        //    id_article   INTEGER IDENTITY(1,1) NOT NULL,
        //    nom_article   VARCHAR(255) NOT NULL,
        //    description   VARCHAR(300) NOT NULL,
        // date_debut_encheres DATE NOT NULL,
        //    date_fin_encheres DATE NOT NULL,
        //    prix_initial  INTEGER,
        //    prix_vente   INTEGER,
        // etat_vente   BIT DEFAULT 0,
        // id_vendeur   INTEGER NOT NULL,
        //    id_categorie  INTEGER NOT NULL
        //)
        //ALTER TABLE ARTICLE ADD constraint article_pk PRIMARY KEY (id_article);
        //ALTER TABLE ARTICLE
        //    ADD CONSTRAINT article_utilisateurVendeur_fk FOREIGN KEY ( id_vendeur )
        //        REFERENCES UTILISATEUR ( id_utilisateur );
        //ALTER TABLE ENCHERE
        //    ADD CONSTRAINT enchere_article_fk FOREIGN KEY ( id_article )
        //        REFERENCES ARTICLE ( id_article );
        //ALTER TABLE ENCHERE
        //    ADD CONSTRAINT utilisateur_article_fk FOREIGN KEY ( id_enchereur )
        //        REFERENCES UTILISATEUR ( id_utilisateur );
        //ALTER TABLE ARTICLE
        //    ADD CONSTRAINT article_categorie_fk FOREIGN KEY ( id_categorie )
        //        REFERENCES CATEGORIE ( id_categorie );
        //ALTER TABLE ENCHERE
        // ADD CONSTRAINT montantEnchere_positif_ck
        // CHECK (montant_enchere > 0);
        //ALTER TABLE RETRAIT
        //    ADD CONSTRAINT retrait_article_fk FOREIGN KEY ( id_article )
        //    REFERENCES ARTICLE ( id_article );
        //Dispose d’un menu contextuel
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
