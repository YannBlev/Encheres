package org.eni.encheres.dal;

import org.eni.encheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    void creerUtilisateur (Utilisateur Utilisateur);
    void supprimerUtilisateur (Utilisateur idSupprimerUtilisateur);
    List<Utilisateur> listerUtilisateurs();
    void getUtilisateurById(int id);

    //    void getUtilisateurByEmail(String email);
}
