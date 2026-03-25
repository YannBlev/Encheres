package org.eni.encheres.service;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.dto.ArticleDto;

import java.util.List;

public interface ArticleVenduService{
    List<ArticleVendu> listArticlesVendu();
    void creerArticleVendu(ArticleDto articleDto);
    void supprimerArticleVendu(int noArticle);
    ArticleVendu consulterArticleVendu(int noArticle);
    void modifierArticleVendu(ArticleVendu article);

}
