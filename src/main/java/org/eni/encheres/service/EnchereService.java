package org.eni.encheres.service;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Enchere;
import org.eni.encheres.bo.Utilisateur;

import java.util.List;

public interface EnchereService {
    void creerEnchere (Enchere enchere);
    void supprimerEnchereParId (int id);
    void supprimerEncheresParIdArticle(int id);
    boolean peutEncherir(Utilisateur utilisateur, ArticleVendu article, int proposition);
    Enchere consulterEncheresParId (int id);
    List<Enchere> ListEncheres ();
    List<Enchere> lastEnchereByEnchereur(int id);
}
