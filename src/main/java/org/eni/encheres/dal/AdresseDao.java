package org.eni.encheres.dal;

import org.eni.encheres.bo.Retrait;

import java.util.List;

public interface AdresseDao {

    List<Retrait> ListAdresse ();
    void creerAdresse(Retrait retrait);
    void supprimerAdresse (int id);
    Retrait consulterAdresseById(int id);

}
