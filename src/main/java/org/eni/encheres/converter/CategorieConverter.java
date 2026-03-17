package org.eni.encheres.converter;

import org.eni.encheres.bo.Categorie;
import org.eni.encheres.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class CategorieConverter implements Converter<String, Categorie> {


    @Autowired
    CategorieService categorieService;

    @Override
    public Categorie convert(String source) {
        return null;
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Categorie, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
