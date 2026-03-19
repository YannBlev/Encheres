package org.eni.encheres.dal.rowmapper;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Categorie;
import org.eni.encheres.bo.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<ArticleVendu> {
    @Override
    public ArticleVendu mapRow(ResultSet rs, int rowNum) throws SQLException {

        ArticleVendu article = new ArticleVendu();
        Utilisateur vendeur = new Utilisateur();
        Categorie categorie = new Categorie();

        categorie.setId(rs.getInt("id_categorie"));
        categorie.setLibelle(rs.getString("libelle"));

        vendeur.setId(rs.getInt("id_utilisateur"));
        vendeur.setRue(rs.getString("rueUtilisateur"));
        vendeur.setCodePostal(rs.getString("code_postalUtilisateur"));
        vendeur.setVille(rs.getString("villeUtilisateur"));

        article.setNoArticle(rs.getInt("id_article"));
        article.setNomArticle(rs.getString("nom_article"));
        article.setDescription(rs.getString("description"));

        article.setCategorie(categorie);
        article.setVendeur(vendeur);

        return article;



    }
}
