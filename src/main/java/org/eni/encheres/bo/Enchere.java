package org.eni.encheres.bo;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public class Enchere {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private DateTimeFormat dateEnchere;
    @NotNull
    private int montantEnchere;

}
