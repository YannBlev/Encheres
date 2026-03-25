package org.eni.encheres.dal.rowmapper;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Categorie;
import org.eni.encheres.bo.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ArticleVenduRowMapper implements RowMapper<ArticleVendu> {
    @Override
    public ArticleVendu mapRow(ResultSet rs, int rowNum) throws SQLException {

        ArticleVendu article = new ArticleVendu();
        Utilisateur vendeur = new Utilisateur();
        Utilisateur acheteur = new Utilisateur();
        Categorie categorie = new Categorie();


        categorie.setId(rs.getInt("id_categorie"));
        categorie.setLibelle(rs.getString("libelle"));

        vendeur.setId(rs.getInt("id_utilisateur"));
        vendeur.setPseudo(rs.getString("pseudo"));
        vendeur.setRue(rs.getString("rueUtilisateur"));
        vendeur.setCodePostal(rs.getString("code_postalUtilisateur"));
        vendeur.setVille(rs.getString("villeUtilisateur"));

        acheteur.setId(rs.getInt("id_enchereur"));
        acheteur.setPseudo(rs.getString("pseudoEnchereur"));
        acheteur.setRue(rs.getString("rueEnchereur"));
        acheteur.setCodePostal(rs.getString("code_postalEnchereur"));
        acheteur.setVille(rs.getString("villeEnchereur"));

        article.setNoArticle(rs.getInt("id_article"));
        article.setNomArticle(rs.getString("nom_article"));
        article.setDescription(rs.getString("description"));
        article.setDateDebutEncheres(rs.getObject("date_debut_encheres", LocalDate.class));
        article.setDateFinEncheres(rs.getObject("date_fin_encheres", LocalDate.class));
        article.setPrixInitial(rs.getInt("prix_initial"));
        article.setPrixVente(rs.getInt("montant_enchere"));
        article.setEtatVente(rs.getByte("etat_vente"));
        article.setImagePath(rs.getString("imagePath"));

        article.setCategorie(categorie);
        article.setVendeur(vendeur);
        article.setAcheteur(acheteur);

        return article;



    }
}
