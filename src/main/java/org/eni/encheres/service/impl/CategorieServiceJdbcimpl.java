package org.eni.encheres.service.impl;

import org.eni.encheres.bo.Categorie;
import org.eni.encheres.dal.CategorieDao;
import org.eni.encheres.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class CategorieServiceJdbcimpl implements CategorieService {

    @Autowired
    private CategorieDao categorieDao;

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
