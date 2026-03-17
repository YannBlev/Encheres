package org.eni.encheres.service;

import org.eni.encheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurService {
     void creerUtilisateur (Utilisateur idUtilisateur);
     void supprimerUtilisateur (Utilisateur idSupprimerUtilisateur);
     List<Utilisateur> listerUtilisateurs();
     void getUtilisateurById(int id);
     void updateUtilisateur(Utilisateur Utilisateur);


                            // TODO a vérifier
                    // void getUtilisateurByEmail(String email);
}

