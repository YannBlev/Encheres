package org.eni.encheres.dal.impl;

import lombok.AllArgsConstructor;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.dal.ArticleVenduDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@AllArgsConstructor
public class ArticleVenduJdbcImpl implements ArticleVenduDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private static final String INSERT = "insert into article (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, id_vendeur, id_categorie ) values (:nom_article, :description,:date_debut_encheres,:date_fin_encheres, :prix_initial,:id_vendeur,:id_categorie )";
    private static final String SELECT = "select * from article";
    private static final String DELETE = "delete from article where id_article = ?";
    private static final String SELECT_BY_ID = "select * from article where id_article = ?";
    private static final String SELECT_ALL= """
            SELECT	a.id_article, a.nom_article, a.description, a.date_debut_encheres, a.date_fin_encheres, a.prix_initial, a.etat_vente,
                    c.id_categorie, c.libelle,
                    u.id_utilisateur, u.rue rueUtilisateur, u.code_postal code_postalUtilisateur, u.ville villeUtilisateur,
                    r.rue rueRetrait, r.code_postal code_postalRetrait, r.ville villeRetrait
            FROM ARTICLE a
            INNER JOIN UTILISATEUR u ON a.id_vendeur = u.id_utilisateur
            INNER JOIN RETRAIT r ON  r.id_article = a.id_article
            INNER JOIN CATEGORIE c ON  c.id_categorie = a.id_categorie;
            """;

    @Override
    public List<ArticleVendu> listArticlesVendu() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(ArticleVendu.class));
    }

    @Override
    public void creerArticleVendu(ArticleVendu articleVendu) {

        MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("nom_article", articleVendu.getNomArticle())
                    .addValue("description", articleVendu.getDescription())
                    .addValue("date_debut_encheres", articleVendu.getDateDebutEncheres())
                    .addValue("date_fin_encheres", articleVendu.getDateFinEncheres())
                    .addValue("prix_initial", articleVendu.getPrixInitial())
                    .addValue("id_vendeur", articleVendu.getVendeur().getId())
                    .addValue("id_categorie", articleVendu.getCategorie().getId());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT,params, keyHolder);
//jdbcTemplate.update(INSERT, articleVendu.getNomArticle(),articleVendu.getDescription(),articleVendu.getDateDebutEncheres(),articleVendu.getDateFinEncheres(),articleVendu.getPrixInitial(),articleVendu.getVendeur().getId(),articleVendu.getCategorie().getId());
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