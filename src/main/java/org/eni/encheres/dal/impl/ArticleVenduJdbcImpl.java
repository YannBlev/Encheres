package org.eni.encheres.dal.impl;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.dal.ArticleVenduDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleVenduJdbcImpl implements ArticleVenduDao {

    private static final String INSERT = "insert into article (nom_article, description,date_debut_enchères,date_fin_encheres, prix_initial, id_acheteur, id_vendeur,id_categorie, id_adresse ) values (?,?,?,?,?,?,?,?,?)";
    private static final String SELECT = "select * from article";
    private static final String DELETE = "delete from article where numero = ?";
    private static final String SELECT_BY_ID = "select * from article where numero = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ArticleVendu> listArticlesVendu() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(ArticleVendu.class));
    }

    @Override
    public void creerArticleVendu(ArticleVendu articleVendu) {

        MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("nom_article", articleVendu.getNomArticle())
                    .addValue("description", articleVendu.getDescription())
                    .addValue("date_debut_enchère", articleVendu.getDateDebutEncheres())
                    .addValue("date_fin_enchère", articleVendu.getDateFinEncheres())
                    .addValue("prix_initial", articleVendu.getPrixInitial())
                    .addValue("id_acheteur", articleVendu.getAcheteur())
                    .addValue("id_vendeur", articleVendu.getVendeur())
                    .addValue("id_catégorie", articleVendu.getCategorie())
                    .addValue("id_adresse", articleVendu.getAdresse());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(INSERT, articleVendu.getNomArticle(),articleVendu.getDescription(),articleVendu.getDateDebutEncheres(),articleVendu.getDateFinEncheres(),articleVendu.getPrixInitial(),articleVendu.getAcheteur().getId(),articleVendu.getVendeur().getId(),articleVendu.getCategorie().getId(),articleVendu.getAdresse().getId());
    }

    @Override
    public void supprimerArticleVendu(int noArticle) {
        jdbcTemplate.update(DELETE, noArticle);
    }

    @Override
    public ArticleVendu consulterArticleByNumero(int noArticle) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(ArticleVendu.class), noArticle);
    }
}