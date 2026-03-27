package org.eni.encheres.dal;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Enchere;

import java.util.List;

public interface EnchereDao {
    void creerEnchere (Enchere enchere);
    void supprimerEnchereParId (int id);
    void supprimerEncheresParIdArticle(int id);
    Integer consulterIdEnchereurParIdArticle(int id);
    Integer consulterMeilleurOffreParIdEnchereurEtIdArticle(int idEnchereur, int idArticle);
    Enchere consulterEncheresParId (int id);
    List<Enchere> ListEncheres ();
    List<Enchere> lastEnchereByEnchereur(int id);
}
