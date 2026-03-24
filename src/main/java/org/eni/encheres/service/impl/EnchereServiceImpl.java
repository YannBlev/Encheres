package org.eni.encheres.service.impl;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Enchere;
import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.dal.EnchereDao;
import org.eni.encheres.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnchereServiceImpl implements EnchereService {

    @Autowired
    EnchereDao enchereDao;

    @Override
    public List<Enchere> ListEncheres() {
        return enchereDao.ListEncheres();
    }

    @Override
    public void creerEnchere(Enchere enchere) {
        enchereDao.creerEnchere(enchere);
    }

    @Override
    public void supprimerEnchere(int noUtilisateur, int noArticle) {
        enchereDao.supprimerEnchere(noUtilisateur, noArticle);

    }

    @Override
    public Enchere consulterEncheresParId(int id) {
        return enchereDao.consulterEncheresParId(id);
    }

    /**
     * Methode pour verifier que l'enchereur ai assez de credits pour pouvoir encherir
     * @param utilisateur
     * @param proposition
     * @return
     */
    @Override
    public boolean peutEncherir(Utilisateur utilisateur, ArticleVendu article, int proposition) {

        //TODO Ajouter une gestion d'exception
        return proposition > utilisateur.getCredit() && proposition > article.getPrixVente();
    }

    public void recrediterEnchereur() {

    }

}
