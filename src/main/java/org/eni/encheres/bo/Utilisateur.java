package org.eni.encheres.bo;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    @NotNull @Size(min=1,max=30) // ID
    private int id;

    @NotNull @Size(min=5,max=30) // Pseudo
    private String pseudo;

    @NotNull @Size(min=5,max=30) // Nom
    private String nom;

    @NotNull @Size(min=5,max=30) // Prenom
    private String prenom;

    @NotNull @Size(min=10,max=30) // Email
    private String email;

    @Size(min=9,max=10) // Telephone
    private String telephone;

    @NotNull @Size(min=5,max=30) // Rue
    private String rue;

    @Pattern(regexp = "\\d{5}")@NotNull@Digits(integer = 5, fraction = 0, message = "Le code postal doit comporter 5 chiffres") // Code Postal
    private String codePostal;

    @NotNull @Size(min=5,max=30) // Ville
    private String ville;

    @Pattern(regexp = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b")@NotNull@Size(min=5,max=30, message = "Le mot de passe doit comporter une suite Alphanumérique") // Mot de Passe
    private String motDePasse;

    @NotNull // Crédit (argent)
    private int credit;

    @NotNull // Administrateur ID (True/False)
    private boolean administrateur;
}
