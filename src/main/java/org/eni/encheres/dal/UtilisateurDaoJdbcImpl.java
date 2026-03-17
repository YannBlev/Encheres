package org.eni.encheres.dal;

import org.eni.encheres.bo.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository

public class UtilisateurDaoJdbcImpl implements UtilisateurDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    private static final String INSERT = "insert into utilisateur (pseudo, nom, prenom, email, telephone, rue, codePostal, ville) values (?,?,?,?,?,?,?)";
    private static final String DELETE = "delete from utilisateur where id = ?";
    private static final String SELECT_BY_ID = "select * from utilisateur where id = ?";
    private static final String SELECT_UTILISATEUR_BY_ID = "select * from utilisateur where id = ?";
    private static final String SELECT = "select * from utilisateur";


    @Override
    public void creerUtilisateur(Utilisateur utilisateur) {
        return jdbcTemplate.update
                (INSERT,utilisateur.getPseudo(),
                        utilisateur.getNom(),
                        utilisateur.getPrenom(),
                        utilisateur.getEmail(),
                        utilisateur.getTelephone(),
                        utilisateur.getRue(),
                        utilisateur.getCodePostal(),
                        utilisateur.getVille();
    }

    @Override
    public void deleteUtilisateur(Utilisateur idSupprimerUtilisateur) {
        return jdbcTemplate.update(DELETE, deleteUtilisateur(idSupprimerUtilisateur);
    }

    @Override
    public Utilisateur consulterUtilisateurParId(long idUtilisateur) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Utilisateur.class), idUtilisateur);
    }

    @Override
    public List<Utilisateur> listerUtilisateurs() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(Utilisateur.class));
    }

    @Override
    public void getUtilisateurById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new BeanPropertyRowMapper<>(Utilisateur.class), getUtilisateurById();

    }
}
