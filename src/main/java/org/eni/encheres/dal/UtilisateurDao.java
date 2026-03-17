package org.eni.encheres.dal;

import org.eni.encheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    void creerUtilisateur (Utilisateur utilisateur);
    void deleteUtilisateur (Utilisateur idSupprimerUtilisateur);
    Utilisateur consulterUtilisateurParId(long id);
    List<Utilisateur> listerUtilisateurs();
    void getUtilisateurById(int id);
}
