package org.eni.encheres.bo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enchere {

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        private DateTimeFormat dateEnchere;
        @NotNull
        private int montantEnchere;

        private Utilisateur utilisateur;
        private ArticleVendu article;

}
