package org.eni.encheres.dal.impl;

import lombok.AllArgsConstructor;
import org.eni.encheres.bo.Enchere;
import org.eni.encheres.dal.EnchereDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EnchereJdbcImpl implements EnchereDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT = "INSERT INTO ENCHERE (id_enchereur, id_article, date_enchere, montant_enchere) VALUES (?,?,?,?)";
    private static final String DELETE = "DELETE FROM ENCHERE WHERE id_enchereur=? AND id_article=?";
    private static final String SELECT_BY_ID = "SELECT * FROM ENCHERE where id_enchere = ?";
    private static final String SELECT = "SELECT * FROM ENCHERE";
    private static final String SELECT_LAST_ENCHEREUR_BY_ARTICLE = "SELECT MAX(id_enchereur) FROM ENCHERE WHERE id_article = ?;";
    private static final String SELECT_MOST_PRICE_BY_ID_ENCHEREUR = "SELECT MAX(montant_enchere) FROM ENCHERE WHERE id_article = ? AND id_enchereur = ?;";
    private static final String SELECT_LAST_ENCHERE_BY_ID_ENCHEREUR = """
            SELECT e.*
            FROM ENCHERE e
            INNER JOIN (SELECT id_article, MAX(montant_enchere) montant_max
            			FROM enchere
            			GROUP BY id_article) max_e
            ON e.id_article = max_e.id_article
            AND e.montant_enchere = max_e.montant_max
            WHERE e.id_enchereur = ?;
            """;
    private static final String DELETE_ENCHERES_BY_ID_ARTICLE = """
            DELETE FROM ENCHERE WHERE id_article = ?;
            """;


    @Override
    public List<Enchere> ListEncheres() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(Enchere.class));
    }

    @Override
    public void creerEnchere(Enchere enchere) {
        jdbcTemplate.update(INSERT, enchere.getUtilisateur().getId(), enchere.getArticle().getNoArticle(), enchere.getDateEnchere(), enchere.getMontantEnchere());
    }

    @Override
    public void supprimerEnchereParId(int id) {
        jdbcTemplate.update(DELETE, id);

    }

    @Override
    public void supprimerEncheresParIdArticle(int id) {
        jdbcTemplate.update(DELETE_ENCHERES_BY_ID_ARTICLE, id);
    }

    @Override
    public Enchere consulterEncheresParId(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Enchere.class), id);
    }

    /**
     * Methode permettant de récupérer l'ID du dernier enchereur selon l'id de l'Article
     * -> RETURN INTEGER pour gerer les null
     */
    @Override
    public Integer consulterIdEnchereurParIdArticle(int id) {
        return jdbcTemplate.queryForObject(
                SELECT_LAST_ENCHEREUR_BY_ARTICLE,
                Integer.class,
                id
        );
    }

    @Override
    public Integer consulterMeilleurOffreParIdEnchereurEtIdArticle(int idEnchereur, int idArticle) {
        return jdbcTemplate.queryForObject(
                SELECT_MOST_PRICE_BY_ID_ENCHEREUR,
                Integer.class,
                idArticle,
                idEnchereur
        );
    }

    @Override
    public List<Enchere> lastEnchereByEnchereur(int id){
        return jdbcTemplate.query(SELECT_LAST_ENCHERE_BY_ID_ENCHEREUR, new BeanPropertyRowMapper<>(Enchere.class), id);
    }
}
