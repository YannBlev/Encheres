package org.eni.encheres.dal;

import org.eni.encheres.bo.ArticleVendu;

import java.util.List;

public interface ArticleVenduDao{
    List<ArticleVendu> listArticlesVendu();
    void createArticleVendu(ArticleVendu articleVendu);
    void deleteArticleVendu (int noArticle);
    ArticleVendu getArticleById(int noArticle);
}
