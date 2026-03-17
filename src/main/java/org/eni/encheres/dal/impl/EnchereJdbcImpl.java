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

    private static final String INSERT = "insert into enchere (no_utilisateur, no_article, date_enchere, montant_enchere) values (?,?,?,?)";
    private static final String DELETE = "delete from enchere where no_utilisateur=? and where no_article=?";
    private static final String SELECT_BY_ID = "select * from enchere where id = ?";
    private static final String SELECT = "select * from enchere";
    @Autowired
    private JdbcClient jdbcClient;


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
}
