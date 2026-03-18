package org.eni.encheres.dal.rowmapper;

import org.eni.encheres.bo.Adresse;
import org.eni.encheres.bo.Categorie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresseRowMapper implements RowMapper<Adresse> {
    @Override
    public Adresse mapRow(ResultSet rs, int rowNum) throws SQLException {

        Adresse adresse = new Adresse();

        adresse.setId(rs.getInt("id_adresse"));
        adresse.setRue(rs.getString("rue"));
        adresse.setCode_postal(rs.getString("code_postal"));
        adresse.setVille(rs.getString("ville"));

        return adresse;

    }
}
