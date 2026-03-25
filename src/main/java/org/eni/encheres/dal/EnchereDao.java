package org.eni.encheres.dal;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Enchere;

import java.util.List;

public interface EnchereDao {

    List<Enchere> ListEncheres ();
    void creerEnchere (Enchere enchere);
    void supprimerEnchereParId (int id);
    Enchere consulterEncheresParId (int id);
    Integer consulterIdEnchereurParIdArticle(int id);
    Integer consulterMeilleurOffreParIdEnchereurEtIdArticle(int idEnchereur, int idArticle);

}
