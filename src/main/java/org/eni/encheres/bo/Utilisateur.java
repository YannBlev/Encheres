package org.eni.encheres.bo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

    private int id;
    @NotNull
    private String pseudo;
    @NotNull@Max(255)
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    private String email;
    @Size(min =10, max=15)
    private String telephone;
    @NotNull
    private String rue;
    @Pattern(regexp = "\\d{5}")@NotNull@Digits(integer = 5, fraction = 0, message = "Le code postal doit comporter 5 chiffres")
    private String codePostal;
    @NotNull
    private String ville;
    @Pattern(regexp = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b")@NotNull@Min(value =5)@Max(value =30, message = "Le mot de passe doit comporter une suite Alphanumérique")
    private String motDePasse;
    @NotNull
    private int credit;
    @NotNull
    private boolean administrateur;
}

