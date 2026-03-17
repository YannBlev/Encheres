package org.eni.encheres.service;

import org.eni.encheres.bo.ArticleVendu;

import java.util.List;

public interface ArticleVenduService{
    List<ArticleVendu> consulterArticlesVendu();
    void creerArticleVendu(ArticleVendu articleVendu);
    ArticleVendu consulterArticleVendu(int noArticle);
    void supprimerArticleVendu(int noArticle);
}
