package org.eni.encheres.service.impl;

import org.eni.encheres.bo.Categorie;
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
    EnchereService enchereService;

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
        // Vérifier s'il y a des enchères en cours pour cette catégorie
//        long nbEncheresEnCours = enchereService."countByCategorieIdByDateDebutEnchere"(id,localDateTime)
////                TODO dans EnchereServiceImpl "countEnchereByIdCategorieByDateDebutEnchere"
//
//        if (nbEncheresEnCours > 0) {
//            // On lance une exception personnalisée ou une erreur explicite
//            throw new Exception("Interdit : cette catégorie possède des enchères en cours.");
//        }
//
//
//        categorieDao.deleteCategorie(idAsupprimer);

    }
}
