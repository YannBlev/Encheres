package org.eni.encheres.service.impl;

import lombok.AllArgsConstructor;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Retrait;
import org.eni.encheres.dal.ArticleVenduDao;
import org.eni.encheres.dal.RetraitDao;
import org.eni.encheres.dto.ArticleDto;
import org.eni.encheres.service.ArticleVenduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Profile("prod")
public class ArticleVenduServiceJdbcImpl implements ArticleVenduService {

    private ArticleVenduDao articleVenduDao;
    private RetraitDao retraitDao;



    @Override
    public List<ArticleVendu> listArticlesVendu() {
        return articleVenduDao.listArticlesVendu();
    }

    @Override
    @Transactional
    public void creerArticleVendu(ArticleDto articleDto) {

        ArticleVendu article = ArticleVendu.builder()
                                .nomArticle(articleDto.getNomArticle())
                                .description(articleDto.getDescription())
                                .dateDebutEncheres(articleDto.getDateDebutEncheres())
                                .dateFinEncheres(articleDto.getDateFinEncheres())
                                .miseAPrix(articleDto.getMiseAPrix())
                                .prixVente(articleDto.getPrixVente())
                                .etatVente(articleDto.getEtatVente())
                                .vendeur(articleDto.getVendeur())
                                .categorie(articleDto.getCategorie())
                                .prixInitial(articleDto.getPrixInitial())
                .build();

        articleVenduDao.creerArticleVendu(article);

        int index = articleVenduDao.listArticlesVendu().size();
        int idArticle = articleVenduDao.listArticlesVendu().get(index-1).getNoArticle();

        Retrait retrait = Retrait.builder()
                .id(idArticle)
                .rue(articleDto.getRue())
                .code_postal(articleDto.getCode_postal())
                .ville(articleDto.getVille())
            .build();

        retraitDao.creerAdresse(retrait);

    }

    @Override
    public ArticleVendu consulterArticleVendu(int noArticle) {
        return articleVenduDao.consulterArticleByNumero(noArticle);
    }

    @Override
    public void supprimerArticleVendu(int noArticle) { articleVenduDao.supprimerArticleVendu(noArticle);}

}

