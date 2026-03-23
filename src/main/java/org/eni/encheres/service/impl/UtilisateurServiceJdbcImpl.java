package org.eni.encheres.service.impl;

import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.dal.UtilisateurDao;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO : Tu regardes quoi là ? Un soucis?


@Service
@Profile("prod")
public class UtilisateurServiceJdbcImpl implements UtilisateurService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UtilisateurDao utilisateurDao;

    @Override
    public void creerUtilisateur(Utilisateur utilisateur) {
        String motDePasseEncode = passwordEncoder.encode(utilisateur.getMotDePasse());
        utilisateur.setMotDePasse(motDePasseEncode);
        utilisateurDao.creerUtilisateur(utilisateur);
    }

    @Override
    public void supprimerUtilisateur(Utilisateur idSupprimerUtilisateur) {
        utilisateurDao.deleteUtilisateur(idSupprimerUtilisateur.getId());
    }
    @Override
    public List<Utilisateur> listerUtilisateurs() {
        return utilisateurDao.listerUtilisateurs();
    }

    @Override
    public Utilisateur getUtilisateurById (int id) {
        return utilisateurDao.consulterUtilisateurParId(id);
    }

    @Override
    public void modifierUtilisateur(Utilisateur utilisateur) {
        Utilisateur utilisateurExistant = utilisateurDao.consulterUtilisateurParId(utilisateur.getId());

        if (utilisateur.getMotDePasse() == null || utilisateur.getMotDePasse().isEmpty()) {
            utilisateur.setMotDePasse(utilisateurExistant.getMotDePasse());
        } else {
            utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        }

        utilisateurDao.modifierUtilisateur(utilisateur);
    }

}
