package org.eni.encheres.dal;

import org.eni.encheres.bo.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
    void creerUtilisateur (Utilisateur utilisateur);
    void deleteUtilisateur (int idSupprimerUtilisateur);

    // TODO A FAIRE
    void updateUtilisateur(Utilisateur idUtilisateur);

    Utilisateur consulterUtilisateurParId(int id);
    List<Utilisateur> listerUtilisateurs();
    void modifierUtilisateur(Utilisateur utilisateur);



    // TODO A RAJOUTER DANS UTILISATEURJDBCIMPL
    /*void modifierUtilisateur (Utilisateur utilisateur);*/
//    Utilisateur findByPseudo(String pseudo);


}
