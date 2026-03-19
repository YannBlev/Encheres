package org.eni.encheres.mapper;

import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.dto.UtilisateurDto;

import java.time.temporal.ChronoUnit;

public class UtilisateurMapper {
    public static UtilisateurDto mapToDto(Utilisateur utilisateur){


        UtilisateurDto utilisateurDto =  UtilisateurDto.builder()
        .rue(utilisateur.getRue())
        .codePostal(utilisateur.getCodePostal())
        .ville(utilisateur.getVille())
        .build();

        return utilisateurDto;
    }



}
