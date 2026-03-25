package org.eni.encheres.controller;

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
    public String changeI18n(String lang) {
        slr.setDefaultLocale(new Locale(lang));
        return "redirect:/login";
    }
}