package org.eni.encheres.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {
    private int noCategorie;
    private String libelle;

    public Categorie(String libelle) {
        this.libelle = libelle;
    }




}
