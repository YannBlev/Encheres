package org.eni.encheres.converter;

import org.eni.encheres.bo.Categorie;
import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.service.CategorieService;
import org.eni.encheres.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurConverter implements Converter<String, Utilisateur> {

    @Autowired
    private UtilisateurService utilisateurService;

    @Override
    public Utilisateur convert(String idFormatTexte) {
        int id = Integer.parseInt(idFormatTexte);
        return utilisateurService.getUtilisateurById(id);
    }

}
