package org.eni.encheres.dal;

import org.eni.encheres.bo.ArticleVendu;

import java.util.List;

public interface ArticleVenduDao{
    List<ArticleVendu> listArticlesVendu();
    void creerArticleVendu(ArticleVendu articleVendu);
    void supprimerArticleVendu (int noArticle);
    ArticleVendu consulterArticleByNumero(int noArticle);
}
