package org.eni.encheres.service;

import org.eni.encheres.bo.Retrait;

import java.util.List;

public interface RetraitService {

    List<Retrait> ListAdresse ();
    void creerAdresse(Retrait retrait);
    void supprimerAdresse (int id);
    Retrait consulterAdresseById(int id);
}
