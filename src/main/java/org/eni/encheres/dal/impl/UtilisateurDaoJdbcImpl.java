package org.eni.encheres.dal.impl;

import org.eni.encheres.bo.Enchere;
import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.dal.UtilisateurDao;
import org.eni.encheres.dal.rowmapper.UtilisateurRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository

public class UtilisateurDaoJdbcImpl implements UtilisateurDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final String INSERT = "insert into utilisateur (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE = "delete from utilisateur where id_utilisateur = ?";
    private static final String SELECT_BY_ID = "select * from utilisateur where id_utilisateur = ?";
    private static final String SELECT = "select * from utilisateur";


    @Override
    public void creerUtilisateur(Utilisateur utilisateur) {
        jdbcTemplate.update
                (INSERT,utilisateur.getPseudo(),
                        utilisateur.getNom(),
                        utilisateur.getPrenom(),
                        utilisateur.getEmail(),
                        utilisateur.getTelephone(),
                        utilisateur.getRue(),
                        utilisateur.getCodePostal(),
                        utilisateur.getVille(),
                        utilisateur.getMotDePasse());
    }
    @Override
    public void deleteUtilisateur(int idSupprimerUtilisateur) {
        jdbcTemplate.update(DELETE, idSupprimerUtilisateur);
    }

    @Override
    public List<Utilisateur> listerUtilisateurs() {
        return jdbcTemplate.query(SELECT, new UtilisateurRowMapper());
    }

    @Override
    public Utilisateur consulterUtilisateurParId(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new UtilisateurRowMapper(), id);

    }
}
