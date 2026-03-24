package org.eni.encheres.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.eni.encheres.bo.Utilisateur;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Classe "WRAPPER" autour de notre classe métier Membre
 * pour pouvoir la passer à Spring Security
 * C'est une classe dite "Technique"
 */
@Data
@AllArgsConstructor
public class UtilisateurSpringSecurity implements UserDetails {

    private Utilisateur utilisateur;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (utilisateur.isAdministrateur()) {
            return List.of(new SimpleGrantedAuthority("ROLE_admin"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_user"));

    }

    @Override
    public @Nullable String getPassword() {
        return utilisateur.getMotDePasse();
    }

    @Override
    public String getUsername() {
        return utilisateur.getEmail();
    }

    public String getPseudo() {
        return utilisateur.getPseudo();
    }

    public int getId() {return utilisateur.getId();}
}
