package org.eni.encheres.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eni.encheres.bo.Categorie;
import org.eni.encheres.bo.Enchere;
import org.eni.encheres.bo.Utilisateur;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {

    private String nomArticle;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDebutEncheres;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFinEncheres;
    private int miseAPrix;
    private Integer prixVente;
    private Byte etatVente;
    private Utilisateur vendeur;
    private Categorie categorie;
    private int prixInitial;
    private int idRetrait;
    private String rue;
    private String code_postal;
    private String ville;
}
