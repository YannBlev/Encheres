package org.eni.encheres.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Controller

public class LanguageController {

    @Autowired

    // on injecte le sessionLocaleResolver pour changer sa valeur dans le @GetMapping

    private SessionLocaleResolver slr;

    @GetMapping("/i18n")

    public String changeI18n(String lang, HttpServletRequest request) {

        slr.setDefaultLocale(new Locale(lang));

        String referer = request.getHeader("Referer");

        if (referer != null) {

            return "redirect:" + referer;

        }

        return "redirect:/";

    }

}
