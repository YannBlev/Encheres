package org.eni.encheres.service.impl;

import org.eni.encheres.bo.Retrait;
import org.eni.encheres.dal.RetraitDao;
import org.eni.encheres.service.RetraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Profile("prod")
public class RetraitServiceJdbcImpl implements RetraitService {

    @Autowired
    RetraitDao retraitDao;

    @Override
    public List<Retrait> ListAdresse() {

        List<Retrait> adresses = retraitDao.ListAdresse();

        return retraitDao.ListAdresse();
    }

    @Override
    public void creerAdresse(Retrait retrait) {
        retraitDao.creerAdresse(retrait);
    }

    @Override
    public void supprimerAdresse(int id) {
        retraitDao.supprimerAdresse(id);
    }

    @Override
    public Retrait consulterAdresseById(int id) {
        return retraitDao.consulterAdresseById(id);
    }
}
