package org.eni.encheres.dal.impl;

import org.eni.encheres.bo.Adresse;
import org.eni.encheres.bo.ArticleVendu;
import org.eni.encheres.dal.AdresseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresseJdbcImpl implements AdresseDao {
    @Override
    public List<Adresse> ListAdresse() {
        return List.of();
    }

    @Override
    public void creerAdresse(Adresse adresse) {

    }

    @Override
    public void supprimerAdresse(int id) {

    }

    @Override
    public ArticleVendu consulterAdresseById(int id) {
        return null;
    }
}
