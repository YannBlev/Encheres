package org.eni.encheres.bo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ArticleVendu {
    @NotEmpty private int noArticle;
    @NotNull private String nomArticle;
    @NotNull private String description;
    private LocalDateTime dateDebutEncheres;
    private LocalDateTime dateFinEncheres;
    @NotEmpty private int miseAPrix;
    @NotEmpty private int prixVente;
    @NotNull private String etatVente;
}
