package org.eni.encheres.bo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eni.encheres.bo.Categorie;
import org.eni.encheres.bo.Utilisateur;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;

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
    private MultipartFile image;
}
