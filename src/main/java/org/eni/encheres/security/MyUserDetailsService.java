package org.eni.encheres.security;

import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service personnalisé d'authentification
 * Si jamais ce service est dans le contexte Spring (@Service)
 * Spring Security va appeler la méthode : loadUserByUsername
 * de ce service lorsque je vais valider le formulaire de connexion
 * Cette méthode renverra à Spring Security les infos de l'utilisateur qui essaye de se connecter.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UtilisateurService utilisateurService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        for (Utilisateur utilisateur : utilisateurService.listerUtilisateurs()) {
            if (utilisateur.getEmail().equals(username)) {return new UtilisateurSpringSecurity(utilisateur);}
        }
        throw new UsernameNotFoundException(username);
    }
}
