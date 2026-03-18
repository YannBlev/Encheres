package org.eni.encheres.converter;

import org.eni.encheres.bo.Categorie;
import org.eni.encheres.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static org.apache.tomcat.util.http.parser.Host.parse;

@Component
public class CategorieConverter implements Converter<String, Categorie> {


    @Autowired
    private CategorieService categorieService;

    @Override
    public Categorie convert(String idFormatTexte) {
        // étape 1 : convertir le texte en nombre
        int id = Integer.parseInt(idFormatTexte); // parseLong transforme du texte à son équivalent au format long

        // étape 2 : retourner le genre correspondant à l'id
        return categorieService.consulterCategorieParId(id);
    }

}
