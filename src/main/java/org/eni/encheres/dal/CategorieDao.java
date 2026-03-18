package org.eni.encheres.dal;

import org.eni.encheres.bo.Categorie;

import java.util.List;

public interface CategorieDao {

    List<Categorie> ListCategorie ();
    Categorie getCategorieById(Integer id);
    void createCategorie (Categorie categorie);
    void deleteCategorie(Integer id);

}
