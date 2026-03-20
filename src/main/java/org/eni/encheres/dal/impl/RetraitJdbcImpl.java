package org.eni.encheres.dal.impl;

import org.eni.encheres.bo.Retrait;
import org.eni.encheres.dal.RetraitDao;
import org.eni.encheres.dal.rowmapper.RetraitRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RetraitJdbcImpl implements RetraitDao {

    private static final String INSERT = "insert into retrait (id_article, rue, code_postal, ville) values (?, ?, ?, ?)";
    private static final String SELECT = "select * from retrait";
    private static final String DELETE = "delete from retrait where id_article = ?";
    private static final String SELECT_BY_ID = "select * from retrait where id_article  = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Retrait> ListAdresse() {
        List<Retrait> retraits = jdbcTemplate.query(SELECT, new RetraitRowMapper());
        return retraits;
    }


    @Override
    public void creerAdresse(Retrait retrait) {
        jdbcTemplate.update(INSERT, retrait.getId(), retrait.getRue(), retrait.getCode_postal(), retrait.getVille());

    }

    @Override
    public void supprimerAdresse(int id) {
        jdbcTemplate.update(DELETE, id);

    }

    @Override
    public Retrait consulterAdresseById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Retrait.class), id);
    }
}
