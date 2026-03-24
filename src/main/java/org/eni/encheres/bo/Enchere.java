package org.eni.encheres.bo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enchere {

    @NotNull
    private int montantEnchere;
    private LocalDate dateEnchere;
    private Utilisateur utilisateur;
    private ArticleVendu article;

}
