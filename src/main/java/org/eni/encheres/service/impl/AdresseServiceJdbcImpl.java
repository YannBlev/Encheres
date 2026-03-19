package org.eni.encheres.service.impl;

import org.eni.encheres.bo.Retrait;
import org.eni.encheres.dal.AdresseDao;
import org.eni.encheres.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Profile("prod")
public class AdresseServiceJdbcImpl implements AdresseService {

    @Autowired
    AdresseDao adresseDao;

    @Override
    public List<Retrait> ListAdresse() {

        List<Retrait> adresses = adresseDao.ListAdresse();

        return adresseDao.ListAdresse();
    }

    @Override
    public void creerAdresse(Retrait retrait) {
        adresseDao.creerAdresse(retrait);
    }

    @Override
    public void supprimerAdresse(int id) {
        adresseDao.supprimerAdresse(id);
    }

    @Override
    public Retrait consulterAdresseById(int id) {
        return adresseDao.consulterAdresseById(id);
    }
}
