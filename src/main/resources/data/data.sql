
/*
	PENSER A SORTIR ET SUPPRIMER LA DATABASE POUR POUVOIR LA CREER
*/
USE demo;
DROP DATABASE ENCHERES_ORG;


CREATE DATABASE ENCHERES_ORG;

-- ENTRER DANS LA DATABASE AFIN D'Y CREER LES TABLES ET CONTRAINTES
USE ENCHERES_ORG;

CREATE TABLE CATEGORIE (
                           id_categorie   INTEGER IDENTITY(1,1) NOT NULL,
                           libelle        VARCHAR(255) NOT NULL
)

ALTER TABLE CATEGORIE ADD constraint categorie_pk PRIMARY KEY (id_categorie);

CREATE TABLE ENCHERE (
                         id_enchere		INTEGER IDENTITY NOT NULL,
                         id_enchereur	INTEGER NOT NULL,
                         id_article		INTEGER NOT NULL,
                         date_enchere	DATETIME NOT NULL,
                         montant_enchere	INTEGER NOT NULL
)

ALTER TABLE ENCHERE ADD constraint enchere_pk PRIMARY KEY (id_enchere);

CREATE TABLE RETRAIT (
                         id_article		INTEGER NOT NULL,
                         rue              VARCHAR(30) NOT NULL,
                         code_postal      VARCHAR(15) NOT NULL,
                         ville            VARCHAR(30) NOT NULL
)

ALTER TABLE RETRAIT ADD constraint retrait_pk PRIMARY KEY  (id_article);

CREATE TABLE UTILISATEUR (
                             id_utilisateur   INTEGER IDENTITY(1,1) NOT NULL,
                             pseudo           VARCHAR(255) UNIQUE NOT NULL,
                             nom              VARCHAR(255) NOT NULL,
                             prenom           VARCHAR(255) NOT NULL,
                             email            VARCHAR(255) UNIQUE NOT NULL,
                             telephone        VARCHAR(15),
                             rue              VARCHAR(255) NOT NULL,
                             code_postal      VARCHAR(10) NOT NULL,
                             ville            VARCHAR(255) NOT NULL,
                             mot_de_passe     VARCHAR(255) NOT NULL,
                             credit           INTEGER NOT NULL,
                             administrateur   BIT NOT NULL
)

ALTER TABLE UTILISATEUR ADD constraint utilisateur_pk PRIMARY KEY (id_utilisateur);

CREATE TABLE ARTICLE (
                         id_article			INTEGER IDENTITY(1,1) NOT NULL,
                         nom_article			VARCHAR(255) NOT NULL,
                         description			VARCHAR(300) NOT NULL,
                         date_debut_encheres	DATE NOT NULL,
                         date_fin_encheres	DATE NOT NULL,
                         prix_initial		INTEGER,
                         prix_vente			INTEGER,
                         etat_vente			BIT DEFAULT 0,
                         imagePath			VARCHAR(300) NOT NULL,
                         id_vendeur			INTEGER NOT NULL,
                         id_categorie		INTEGER NOT NULL
)

ALTER TABLE ARTICLE ADD constraint article_pk PRIMARY KEY (id_article);

ALTER TABLE ARTICLE
    ADD CONSTRAINT article_utilisateurVendeur_fk FOREIGN KEY ( id_vendeur )
        REFERENCES UTILISATEUR ( id_utilisateur ) on delete cascade;

ALTER TABLE ENCHERE
    ADD CONSTRAINT enchere_article_fk FOREIGN KEY ( id_article )
        REFERENCES ARTICLE ( id_article );

ALTER TABLE ENCHERE
    ADD CONSTRAINT utilisateur_article_fk FOREIGN KEY ( id_enchereur )
        REFERENCES UTILISATEUR ( id_utilisateur ) on delete cascade;

ALTER TABLE ARTICLE
    ADD CONSTRAINT article_categorie_fk FOREIGN KEY ( id_categorie )
        REFERENCES CATEGORIE ( id_categorie );

ALTER TABLE ENCHERE
    ADD CONSTRAINT montantEnchere_positif_ck
        CHECK (montant_enchere > 0);

ALTER TABLE RETRAIT
    ADD CONSTRAINT retrait_article_fk FOREIGN KEY ( id_article )
        REFERENCES ARTICLE ( id_article );