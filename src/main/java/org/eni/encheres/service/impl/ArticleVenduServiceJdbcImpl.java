package org.eni.encheres.service.impl;

import lombok.AllArgsConstructor;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Retrait;
import org.eni.encheres.dal.ArticleVenduDao;
import org.eni.encheres.dal.EnchereDao;
import org.eni.encheres.dal.RetraitDao;
import org.eni.encheres.bo.dto.ArticleDto;
import org.eni.encheres.service.ArticleVenduService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Profile("prod")
public class ArticleVenduServiceJdbcImpl implements ArticleVenduService {

    private ArticleVenduDao articleVenduDao;
    private RetraitDao retraitDao;
    private EnchereDao enchereDao;



    @Override
    public List<ArticleVendu> listArticlesVendu() {
        List<ArticleVendu> articles = articleVenduDao.listArticlesVendu();

        /**
         * A chaque chargement des articles dans la BDD, on met à jour l'état de la vente et on supprime l'article s'il aucun enchereur
         */
        articles.forEach(a -> {
            if (a.getDateFinEncheres().isBefore(LocalDate.now())) {

                a.setEtatVente((byte) 1);
                articleVenduDao.modifierArticleVendu(a);

                if (a.getPrixVente()<a.getPrixInitial()) {
                    articleVenduDao.supprimerArticleVendu(a.getNoArticle());
                }

            }
        });

        articles = articleVenduDao.listArticlesVendu();
        return articles;
    }

    @Override
    public List<ArticleVendu> listArticlesVenduParCategorie(int id) {return articleVenduDao.listArticlesVenduParCategorie(id);}

    /**
     * @Transactionnal est important pour l'atomicité de l'ACID !
     */
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
                                .imagePath(articleDto.getImagePath())
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

    /**
     * Methode transactionnal pour bien supprimer les ARTICLE et les ENCHERE
     */
    @Override
    @Transactional
    public void supprimerArticleVendu(int noArticle) {
        enchereDao.supprimerEncheresParIdArticle(noArticle);
        articleVenduDao.supprimerArticleVendu(noArticle);
    }

    @Override
    public void modifierArticleVendu(ArticleVendu article) {
        articleVenduDao.modifierArticleVendu(article);
    }

}

