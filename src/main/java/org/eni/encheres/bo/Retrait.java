package org.eni.encheres.bo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.management.Query.value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Retrait {
   @NotEmpty private int no_article;

   private Adresse adresse;
}
