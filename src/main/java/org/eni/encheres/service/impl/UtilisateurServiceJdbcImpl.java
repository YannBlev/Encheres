package org.eni.encheres.service.impl;

import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class UtilisateurServiceJdbcImpl implements UtilisateurService {
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
