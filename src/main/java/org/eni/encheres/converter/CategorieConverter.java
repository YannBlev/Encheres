package org.eni.encheres.converter;

import org.eni.encheres.bo.Categorie;
import org.eni.encheres.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategorieConverter implements Converter<String, Categorie> {

    @Autowired
    private CategorieService categorieService;

    @Override
    public Categorie convert(String idFormatTexte) {
        int id = Integer.parseInt(idFormatTexte);
        return categorieService.consulterCategorieParId(id);
    }

}
