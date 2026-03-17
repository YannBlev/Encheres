package org.eni.encheres.service;

import org.eni.encheres.bo.Utilisateur;

import java.util.List;

public class UtilisateurServiceJdbcImpl implements UtilisateurService{
    @Override
    public void creerUtilisateur(Utilisateur utilisateur) {
        creerUtilisateur(utilisateur);
    }
    @Override
    public void supprimerUtilisateur (Utilisateur utilisateur){
         supprimerUtilisateur(utilisateur);
    }

    @Override
    public List<Utilisateur> listerUtilisateurs() {
        return listerUtilisateurs();
    }

    @Override
    public void getUtilisateurById (int id) {
        getUtilisateurById(id);
    }

    @Override
    public void updateUtilisateur (Utilisateur utilisateur) {
        updateUtilisateur(utilisateur);
    }


}
