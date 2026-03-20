package org.eni.encheres.dal;

import org.eni.encheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    void creerUtilisateur (Utilisateur utilisateur);
    void deleteUtilisateur (int idSupprimerUtilisateur);
    Utilisateur consulterUtilisateurParId(int id);
    List<Utilisateur> listerUtilisateurs();



    // TODO A RAJOUTER DANS UTILISATEURJDBCIMPL
    /*void modifierUtilisateur (Utilisateur utilisateur);*/
//    Utilisateur findByPseudo(String pseudo);


}
