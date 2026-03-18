package org.eni.encheres.dal.impl;


import org.eni.encheres.bo.Categorie;
import org.eni.encheres.dal.CategorieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategorieDaoJdbcImpl implements CategorieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final String INSERT = "insert into categorie (libelle) values (?)";
    private static final String SELECT = "select * from categorie";
    private static final String SELECT_BY_ID = "select * from categorie where id = ?";
    private static final String DELETE = "delete from categorie where id = ?";



    @Override
    public List<Categorie> ListCategorie() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(Categorie.class));
    }

    public void createCategorie(Categorie categorie) {
        jdbcTemplate.update(INSERT, categorie.getLibelle());



    }

    @Override
    public void deleteCategorie(int id) {
        jdbcTemplate.update(DELETE,id);

    }

    @Override
    public Categorie getCategorieById(int id) {

        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Categorie.class), id);
    }
}
