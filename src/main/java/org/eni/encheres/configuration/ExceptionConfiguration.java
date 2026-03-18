package org.eni.encheres.configuration;

import org.eni.encheres.service.exception.ServiceRunTimeException;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Configuration
public class ExceptionConfiguration {

    @ExceptionHandler(ServiceRunTimeException.class)
    public String HandlerServiceRunTimeException(ServiceRunTimeException e, Model model) {
        model.addAttribute("error", "J'ai un probleme de base de données");
        return "page/error";
    }
}
