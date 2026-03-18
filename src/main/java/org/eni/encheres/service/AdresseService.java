package org.eni.encheres.service;

import org.eni.encheres.bo.Adresse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdresseService {

    List<Adresse> ListAdresse ();
    void creerAdresse(Adresse adresse);
    void supprimerAdresse (int id);
    Adresse consulterAdresseById(int id);
}
