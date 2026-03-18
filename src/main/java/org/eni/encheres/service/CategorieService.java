package org.eni.encheres.service;

import org.eni.encheres.bo.Categorie;

import java.util.List;

public interface CategorieService {


    List<Categorie> consulterCategorie();
    void creerCategorie(Categorie categorie);
    Categorie consulterCategorieParId(Integer id);
    void supprimerCategorie(Integer idAsupprimer);
}
