package org.eni.encheres.dal.impl;

import org.eni.encheres.bo.Adresse;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.dal.AdresseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresseJdbcImpl implements AdresseDao {

    private static final String INSERT = "insert into adresse (rue, code_postal, ville) values (?, ?, ?)";
    private static final String SELECT = "select * from adresse";
    private static final String DELETE = "delete from adresse where id = ?";
    private static final String SELECT_BY_ID = "select * from adresse where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AdresseDao adresseDao;

    @Override
    public List<Adresse> ListAdresse() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(Adresse.class));
    }

    @Override
    public void creerAdresse(Adresse adresse) {
        jdbcTemplate.update(INSERT, adresse.getRue(), adresse.getCode_postal(), adresse.getVille());

    }

    @Override
    public void supprimerAdresse(int id) {
        jdbcTemplate.update(DELETE, id);

    }

    @Override
    public Adresse consulterAdresseById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Adresse.class), id);
    }
}
