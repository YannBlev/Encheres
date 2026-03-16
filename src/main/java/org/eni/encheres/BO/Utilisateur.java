package org.eni.encheres.bo;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.List;
@Data
public class Utilisateur {

    @NotNull@Min(value = 5)@Max(value = 30)
    private int id;
    @NotNull@Min(value =3)@Max(value =30)
    private String pseudo;
    @NotNull@Min(value =5)@Max(value =30)
    private String nom;
    @NotNull@Min(value =5)@Max(value =30)
    private String prenom;
    @NotNull@Min(value =10)@Max(value =20)
    private String email;
    @Min(value =5)@Max(value =10)
    private String telephone;
    @NotNull@Min(value =5)@Max(value =30)
    private String rue;
    @Pattern(regexp = "\\d{5}")@NotNull@Digits(integer = 5, fraction = 0, message = "Le code postal doit comporter 5 chiffres")
    private String codePostal;
    @NotNull@Min(value =5)@Max(value =30)
    private String ville;
    @Pattern(regexp = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b")@NotNull@Min(value =5)@Max(value =30, message = "Le mot de passe doit comporter une suite Alphanumérique")
    private String motDePasse;
    @NotNull
    private int credit;
    @NotNull
    private boolean administrateur;
}
