package org.eni.encheres.bo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleVendu {

    @NotEmpty private int noArticle;
    @NotNull private String nomArticle;
    @NotNull private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDebutEncheres;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFinEncheres;
    @NotEmpty private int miseAPrix;
    private Integer prixVente;
    @NotNull private Byte etatVente;
    @NotNull private Utilisateur vendeur;
    @NotNull private Utilisateur acheteur;
    @NotNull private Enchere enchere;
    @NotNull private Categorie categorie;
    @NotNull private int prixInitial;
    private String imagePath;
}
