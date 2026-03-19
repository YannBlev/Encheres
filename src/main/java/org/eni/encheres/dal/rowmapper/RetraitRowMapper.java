package org.eni.encheres.dal.rowmapper;

import org.eni.encheres.bo.Retrait;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RetraitRowMapper implements RowMapper<Retrait> {
    @Override
    public Retrait mapRow(ResultSet rs, int rowNum) throws SQLException {

        Retrait retrait = new Retrait();

        retrait.setId(rs.getInt("id_adresse"));
        retrait.setRue(rs.getString("rue"));
        retrait.setCode_postal(rs.getString("code_postal"));
        retrait.setVille(rs.getString("ville"));

        return retrait;

    }
}
