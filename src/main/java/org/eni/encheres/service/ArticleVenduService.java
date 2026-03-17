package org.eni.encheres.service;

import org.eni.encheres.bo.ArticleVendu;

import java.util.List;

public interface ArticleVenduService{
    List<ArticleVendu> listArticlesVendu();
    void creerArticleVendu(ArticleVendu articleVendu);
    void supprimerArticleVendu(int noArticle);
    ArticleVendu consulterArticleVendu(int noArticle);
}
