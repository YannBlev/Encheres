package org.eni.encheres.dal;

import org.eni.encheres.bo.Adresse;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Categorie;

import java.util.List;

public interface AdresseDao {

    List<Adresse> ListAdresse ();
    void creerAdresse(Adresse adresse);
    void supprimerAdresse (int id);
    Adresse consulterAdresseById(int id);

}
