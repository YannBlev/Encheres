package org.eni.encheres.service;

import org.eni.encheres.bo.Categorie;

import java.util.List;

public class CategorieServiceJdbcimpl implements CategorieService{
    @Override
    public List<Categorie> consulterCategorie() {
        return List.of();
    }

    @Override
    public void creerCategorie(Categorie categorie) {

    }

    @Override
    public Categorie consulterCategorieParNo(int noCategorie) {
        return null;
    }

    @Override
    public void supprimerCategorie(int noCategorieAsupprimer) {

    }
}
