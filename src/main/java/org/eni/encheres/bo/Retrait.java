package org.eni.encheres.bo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Retrait {

    private int id;

    @NotNull
    @Size(min = 1, max = 30, message = "La longueur doit être comprise entre 1 et 30 caractères")
    private String rue;

    @NotNull
    @Size(min = 1, max = 15, message = "La longueur doit être comprise entre 1 et 15 caractères")
    @Pattern(regexp = "^[0-9]*$", message = "Seuls les chiffres sont autorisés")
    private String code_postal;

    @NotNull
    @Size (min = 1, max = 30, message = "La longueur doit être comprise entre 1 et 30 caractères")
    private String ville;


}
