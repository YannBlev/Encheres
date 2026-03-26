package org.eni.encheres.service.impl;

import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.bo.Categorie;
import org.eni.encheres.dal.ArticleVenduDao;
import org.eni.encheres.dal.CategorieDao;
import org.eni.encheres.service.CategorieService;
import org.eni.encheres.service.EnchereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Profile("prod")
public class CategorieServiceJdbcimpl implements CategorieService {

    @Autowired
    private CategorieDao categorieDao;

    @Autowired
    private ArticleVenduDao articleVenduDao;

    @Autowired
    private ArticleVenduServiceJdbcImpl articleVenduServiceJdbcImpl;

    @Override
    public List<Categorie> consulterCategorie() {
        return categorieDao.ListCategorie();
    }

    @Override
    public Categorie consulterCategorieParId(int id) {
        return categorieDao.getCategorieById(id);
    }

    @Override
    public void creerCategorie(Categorie categorie) {
        categorieDao.createCategorie(categorie);

    }


    @Override
    public void supprimerCategorie(int idAsupprimer) {

             categorieDao.deleteCategorie(idAsupprimer);

    }
}









//try {
//// 1. Vérifier si la catégorie contient des articles
//// On suppose que vous avez une méthode dans votre DAO pour compter les articles
//int nombreArticles = articleDao.countArticlesByCategorie(idAsupprimer);
//
//        if (nombreArticles > 0) {
//        // On lance une exception personnalisée ou une RuntimeException
//        throw new IllegalStateException("Impossible de supprimer la catégorie : elle contient des articles.");
//        }
//
//                // 2. Si aucun article, on procède à la suppression
//                categorieDao.deleteCategorie(idAsupprimer);
//        System.out.println("Catégorie supprimée avec succès.");

