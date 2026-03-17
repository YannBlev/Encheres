package org.eni.encheres.service.impl;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.dal.ArticleVenduDao;
import org.eni.encheres.service.ArticleVenduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")

public class ArticleVenduServiceJdbcImpl implements ArticleVenduService {

    @Autowired
    private ArticleVenduDao articleVenduDao;


    @Override
    public List<ArticleVendu> listArticlesVendu() {
        return articleVenduDao.listArticlesVendu();
    }

    @Override
    public void creerArticleVendu(ArticleVendu articleVendu) { articleVenduDao.creerArticleVendu(articleVendu);}

    @Override
    public ArticleVendu consulterArticleVendu(int noArticle) {
        return articleVenduDao.consulterArticleByNumero(noArticle);
    }

    @Override
    public void supprimerArticleVendu(int noArticle) { articleVenduDao.supprimerArticleVendu(noArticle);}

}

