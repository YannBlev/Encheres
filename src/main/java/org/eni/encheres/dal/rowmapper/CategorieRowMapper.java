package org.eni.encheres.dal.rowmapper;

import org.eni.encheres.bo.Categorie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategorieRowMapper implements RowMapper<Categorie> {
    @Override
    public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {

        Categorie categorie = new Categorie();

        categorie.setId(rs.getInt("id_categorie"));
        categorie.setLibelle(rs.getString("libelle"));

        return categorie;



    }
}
