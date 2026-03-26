package org.eni.encheres.service;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Enchere;
import org.eni.encheres.bo.Utilisateur;

import java.util.List;

public interface EnchereService {

    List<Enchere> ListEncheres ();
    void creerEnchere (Enchere enchere);
    void supprimerEnchereParId (int id);
    Enchere consulterEncheresParId (int id);
    boolean peutEncherir(Utilisateur utilisateur, ArticleVendu article, int proposition);
    List<Enchere> lastEnchereByEnchereur(int id);
}
