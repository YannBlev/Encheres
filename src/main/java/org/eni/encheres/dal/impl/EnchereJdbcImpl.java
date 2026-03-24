package org.eni.encheres.dal.impl;

import org.eni.encheres.bo.Enchere;
import org.eni.encheres.dal.EnchereDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnchereJdbcImpl implements EnchereDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT = "insert into enchere (id_enchereur, id_article, date_enchere, montant_enchere) values (?,?,?,?)";
    private static final String DELETE = "delete from enchere where id_enchereur=? and id_article=?";
    private static final String SELECT_BY_ID = "select * from enchere where id_enchere = ?";
    private static final String SELECT = "select * from enchere";
    private static final String SELECT_LAST_ENCHEREUR_BY_ARTICLE = "SELECT id_enchereur FROM ENCHERE WHERE id_article = ?;";

    @Override
    public List<Enchere> ListEncheres() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(Enchere.class));
    }

    @Override
    public void creerEnchere(Enchere enchere) {
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

    public int consulterIdEnchereurParIdArticle(int id) {
//        return jdbcTemplate.query(SELECT_LAST_ENCHEREUR_BY_ARTICLE, new BeanPropertyRowMapper<>(Enchere.class), id);
    return  0;
    }
}
