package org.eni.encheres.service;

import org.eni.encheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurService {
     void creerUtilisateur (Utilisateur idUtilisateur);
     void supprimerUtilisateur (Utilisateur idSupprimerUtilisateur);
     List<Utilisateur> listerUtilisateurs();
     Utilisateur getUtilisateurById(int id);
     void modifierUtilisateur(Utilisateur idUtilisateur);
//    Utilisateur trouverParPseudo(String pseudo);


    // TODO a vérifier
                    // void getUtilisateurByEmail(String email);
}

