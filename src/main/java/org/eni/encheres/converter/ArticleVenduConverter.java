package org.eni.encheres.converter;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.service.ArticleVenduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArticleVenduConverter implements Converter<String, ArticleVendu> {

    @Autowired
    private ArticleVenduService articleVenduService;

    @Override
    public ArticleVendu convert(String idFormatTexte) {
        int id = Integer.parseInt(idFormatTexte);
        ArticleVendu art = articleVenduService.consulterArticleVendu(id);
        System.out.println("Conversion catégorie : " + id + " -> " + art);
        return articleVenduService.consulterArticleVendu(id);
    }

}
