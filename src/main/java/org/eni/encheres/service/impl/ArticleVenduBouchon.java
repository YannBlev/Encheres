package org.eni.encheres.service.impl;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.dal.ArticleVenduDao;
import org.eni.encheres.bo.dto.ArticleDto;
import org.eni.encheres.service.ArticleVenduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("dev")

public class ArticleVenduBouchon implements ArticleVenduService {

    @Autowired
    private ArticleVenduDao articleVenduDao;

    private static List<ArticleVendu> LstArticleVendu = new ArrayList<>();
    private static int indexArticlesVendu = 1;


    @Override
    public List<ArticleVendu> listArticlesVendu() {
        return null;
    }

    @Override
    public void creerArticleVendu(ArticleDto articleDto) {

    }

    @Override
    public ArticleVendu consulterArticleVendu(int noArticle) {
        return null;
    }

    @Override
    public void modifierArticleVendu(ArticleVendu article) {

    }

    @Override
    public void supprimerArticleVendu(int noArticle) {

    }
}
