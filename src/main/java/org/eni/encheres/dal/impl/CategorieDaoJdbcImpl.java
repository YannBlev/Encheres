package org.eni.encheres.dal.impl;


import org.eni.encheres.bo.Categorie;
import org.eni.encheres.dal.CategorieDao;
import org.eni.encheres.dal.rowmapper.CategorieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("prod")
public class CategorieDaoJdbcImpl implements CategorieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final String INSERT = """
                        INSERT INTO CATEGORIE (libelle) VALUES (?)
                        """;

    private static final String SELECT = """
                        SELECT * FROM CATEGORIE
                        """;

    private static final String SELECT_BY_ID = SELECT + """
                        WHERE id_categorie = ?
                        """;

    private static final String DELETE = """
                        DELETE FROM CATEGORIE WHERE id_categorie = ?
                        """;



    @Override
    public List<Categorie> ListCategorie() {
        return jdbcTemplate.query(SELECT, new CategorieRowMapper());
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
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new CategorieRowMapper(), id);
    }
}
