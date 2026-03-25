package org.eni.encheres.dal.impl;

import lombok.AllArgsConstructor;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.dal.ArticleVenduDao;
import org.eni.encheres.dal.rowmapper.ArticleVenduRowMapper;
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

    private static final String INSERT = """
        INSERT INTO article (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, imagePath, id_vendeur, id_categorie )
        VALUES (:nom_article, :description,:date_debut_encheres,:date_fin_encheres, :prix_initial, :imagePath,:id_vendeur,:id_categorie );
        """;
    private static final String DELETE = "delete from article where id_article = ?";
    //La sous-requete est là pour ne récupérer qu'une seule ligne
    private static final String SELECT_ALL= """
            SELECT	a.id_article, a.nom_article, a.description, a.date_debut_encheres, a.date_fin_encheres, a.prix_initial, a.etat_vente, a.prix_vente, a.imagePath,
                    c.id_categorie, c.libelle,
                    u.id_utilisateur, u.telephone, u.rue rueUtilisateur, u.code_postal code_postalUtilisateur, u.ville villeUtilisateur, u.pseudo,
                    r.rue rueRetrait, r.code_postal code_postalRetrait, r.ville villeRetrait,
                    e.montant_enchere, e.id_enchereur,
                    enchereur.rue rueEnchereur, enchereur.code_postal code_postalEnchereur, enchereur.ville villeEnchereur, enchereur.pseudo pseudoEnchereur
            FROM ARTICLE a
            INNER JOIN UTILISATEUR u ON a.id_vendeur = u.id_utilisateur
            LEFT JOIN RETRAIT r ON r.id_article = a.id_article
            INNER JOIN CATEGORIE c ON  c.id_categorie = a.id_categorie
            LEFT JOIN ENCHERE e
                ON e.id_article = a.id_article
                AND e.montant_enchere = (
                    SELECT MAX(montant_enchere)
                    FROM ENCHERE
                    WHERE id_article = a.id_article
                )
            LEFT JOIN UTILISATEUR enchereur ON e.id_enchereur = enchereur.id_utilisateur
            """;
    private static final String SELECT_BY_ID = SELECT_ALL + """
        WHERE a.id_article = ?
        """;

    private static final String UPDATE = """
        UPDATE ARTICLE SET
        nom_article = ?,
        description = ?,
        date_debut_encheres = ?,
        date_fin_encheres = ?,
        prix_initial = ?,
        prix_vente = ?,
        etat_vente = ?,
        imagePath = ?,
        id_vendeur = ?,
        id_categorie = ?
        WHERE id_article = ?
        """;


    @Override
    public List<ArticleVendu> listArticlesVendu() {
        return jdbcTemplate.query(SELECT_ALL, new ArticleVenduRowMapper());
    }

    @Override
    public void creerArticleVendu(ArticleVendu articleVendu) {

        MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("nom_article", articleVendu.getNomArticle())
                    .addValue("description", articleVendu.getDescription())
                    .addValue("date_debut_encheres", articleVendu.getDateDebutEncheres())
                    .addValue("date_fin_encheres", articleVendu.getDateFinEncheres())
                    .addValue("prix_initial", articleVendu.getPrixInitial())
                    .addValue("imagePath", articleVendu.getImagePath())
                    .addValue("id_vendeur", articleVendu.getVendeur().getId())
                    .addValue("id_categorie", articleVendu.getCategorie().getId());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT,params, keyHolder);
    }

    @Override
    public void supprimerArticleVendu(int noArticle) {
        jdbcTemplate.update(DELETE, noArticle);
    }

    @Override
    public ArticleVendu consulterArticleByNumero(int noArticle) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new ArticleVenduRowMapper(), noArticle);
    }

    @Override
    public void modifierArticleVendu(ArticleVendu article) {
        jdbcTemplate.update(UPDATE,
                article.getNomArticle(),
                article.getDescription(),
                article.getDateDebutEncheres(),
                article.getDateFinEncheres(),
                article.getPrixInitial(),
                article.getPrixVente(),
                article.getEtatVente(),
                article.getImagePath(),
                article.getVendeur().getId(),
                article.getCategorie().getId(),
                article.getNoArticle()
        );
    }
}