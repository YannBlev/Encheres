package org.eni.encheres.dal.impl;

import lombok.AllArgsConstructor;
import org.eni.encheres.bo.Enchere;
import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.dal.EnchereDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class EnchereJdbcImpl implements EnchereDao {

    private JdbcTemplate jdbcTemplate;

    private static final String INSERT = "insert into enchere (id_enchereur, id_article, date_enchere, montant_enchere) values (?,?,?,?)";
    private static final String DELETE = "delete from enchere where id_enchereur=? and id_article=?";
    private static final String SELECT_BY_ID = "select * from enchere where id_enchere = ?";
    private static final String SELECT = "select * from enchere";
    private static final String SELECT_LAST_ENCHEREUR_BY_ARTICLE = "SELECT MAX(id_enchereur) FROM ENCHERE WHERE id_article = ?;";
    private static final String SELECT_MOST_PRICE_BY_ID_ENCHEREUR = "SELECT MAX(montant_enchere) FROM ENCHERE WHERE id_article = ? AND id_enchereur = ?;";

    @Override
    public List<Enchere> ListEncheres() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(Enchere.class));
    }

    @Override
    public void creerEnchere(Enchere enchere) {
        int idArticle = enchere.getArticle().getNoArticle();
        int idDernierEnchereur = consulterIdEnchereurParIdArticle(idArticle);
        int derniereProposition = consulterMeilleurOffreParIdEnchereurEtIdArticle(idDernierEnchereur, idArticle);


        jdbcTemplate.update(INSERT, enchere.getUtilisateur().getId(), enchere.getArticle().getNoArticle(), enchere.getDateEnchere(), enchere.getMontantEnchere());

    }

    @Override
    public void supprimerEnchere(int noUtilisateur, int noArticle) {
        jdbcTemplate.update(DELETE, noUtilisateur, noArticle);

    }

    @Override
    public Enchere consulterEncheresParId(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Enchere.class), id);
    }

    /**
     * Methode permettant de récupérer l'ID du dernier enchereur selon l'id de l'Article
     */
    public int consulterIdEnchereurParIdArticle(int id) {
        return jdbcTemplate.update(SELECT_LAST_ENCHEREUR_BY_ARTICLE, new BeanPropertyRowMapper<>(Enchere.class), id);
    }

    public int consulterMeilleurOffreParIdEnchereurEtIdArticle(int idEnchereur, int idArticle) {
        return jdbcTemplate.update(SELECT_LAST_ENCHEREUR_BY_ARTICLE, new BeanPropertyRowMapper<>(Enchere.class), idEnchereur, idArticle);
    }
}
