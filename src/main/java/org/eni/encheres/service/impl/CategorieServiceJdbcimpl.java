package org.eni.encheres.service.impl;

import org.eni.encheres.bo.Categorie;
import org.eni.encheres.dal.CategorieDao;
import org.eni.encheres.service.CategorieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceJdbcimpl implements CategorieService {

    private CategorieDao categorieDao;

    @Override
    public List<Categorie> consulterCategorie() {
        return categorieDao.ListCategorie();
    }

    @Override
    public Categorie consulterCategorieParNo(int noCategorie) {
        return categorieDao.getCategorieByNo(noCategorie);
    }

    @Override
    public void creerCategorie(Categorie categorie) {
        categorieDao.createCategorie(categorie);

    }



    @Override
    public void supprimerCategorie(int noCategorieAsupprimer) {
        categorieDao.deleteCategorie(noCategorieAsupprimer);

    }
}
