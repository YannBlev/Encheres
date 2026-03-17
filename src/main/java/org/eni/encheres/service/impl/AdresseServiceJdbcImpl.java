package org.eni.encheres.service.impl;

import org.eni.encheres.bo.Adresse;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.dal.AdresseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Profile("prod")
public class AdresseServiceJdbcImpl implements AdresseDao {

    @Autowired
    AdresseDao adresseDao;

    @Override
    public List<Adresse> ListAdresse() {
        return adresseDao.ListAdresse();
    }

    @Override
    public void creerAdresse(Adresse adresse) {
        adresseDao.creerAdresse(adresse);
    }

    @Override
    public void supprimerAdresse(int id) {
        adresseDao.supprimerAdresse(id);
    }

    @Override
    public ArticleVendu consulterAdresseById(int id) {
        return adresseDao.consulterAdresseById(id);
    }
}
