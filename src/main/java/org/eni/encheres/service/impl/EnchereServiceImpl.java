package org.eni.encheres.service.impl;

import lombok.AllArgsConstructor;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Enchere;
import org.eni.encheres.bo.Utilisateur;
import org.eni.encheres.dal.EnchereDao;
import org.eni.encheres.dal.UtilisateurDao;
import org.eni.encheres.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EnchereServiceImpl implements EnchereService {

    EnchereDao enchereDao;
    UtilisateurDao utilisateurDao;

    @Override
    public List<Enchere> ListEncheres() {
        return enchereDao.ListEncheres();
    }

    @Override
    @Transactional
    public void creerEnchere(Enchere enchere) {

        /**
         * GESTION DE L'ANCIEN ENCHEREUR POUR QUE CELUI-CI RETROUVE SES CREDITS
         * (SI EXISTE UN ANCIEN ENCHEREUR)
         */
        int idArticle = enchere.getArticle().getNoArticle();
        Integer idAncienEnchereur = enchereDao.consulterIdEnchereurParIdArticle(idArticle);

        if (idAncienEnchereur != null) {

            int ancienneProposition = enchereDao
                    .consulterMeilleurOffreParIdEnchereurEtIdArticle(idAncienEnchereur, idArticle);

            Utilisateur ancienEnchereur = utilisateurDao
                    .consulterUtilisateurParId(idAncienEnchereur);

            int creditAncienEnchereurAvant = ancienEnchereur.getCredit();
            ancienEnchereur.setCredit(creditAncienEnchereurAvant + ancienneProposition);

            utilisateurDao.modifierUtilisateur(ancienEnchereur);
        }

        /**
         * GESTION DU NOUVEL ENCHEREUR POUR QUE CELUI-CI PERDE SES CREDITS
         */
        Utilisateur nouvelEnchereur = enchere.getUtilisateur();
        int creditNouvelEnchereurAvant = nouvelEnchereur.getCredit();
        nouvelEnchereur.setCredit(creditNouvelEnchereurAvant - enchere.getMontantEnchere());
        utilisateurDao.modifierUtilisateur(nouvelEnchereur);

        enchere.setUtilisateur(nouvelEnchereur);


        /**
         * CREATION DE L'ENCHERE
         */
        enchereDao.creerEnchere(enchere);
    }


    @Override
    public Enchere consulterEncheresParId(int id) {
        return enchereDao.consulterEncheresParId(id);
    }

    /**
     * Methode pour verifier que l'enchereur ai assez de credits pour pouvoir encherir
     */
    @Override
    public boolean peutEncherir(Utilisateur utilisateur, ArticleVendu article, int proposition) {

        //TODO Ajouter une gestion d'exception
        return proposition < utilisateur.getCredit() && proposition > article.getPrixVente() && proposition > article.getPrixInitial();
    }

    @Override
    public List<Enchere> lastEnchereByEnchereur(int id) {
        return enchereDao.lastEnchereByEnchereur(id);
    }

    @Override
    public void supprimerEnchereParId(int id) {enchereDao.supprimerEnchereParId(id);
    }
}
