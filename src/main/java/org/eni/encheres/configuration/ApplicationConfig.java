package org.eni.encheres.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class ApplicationConfig {
    @Bean
    public SessionLocaleResolver localeResolver() {
        SessionLocaleResolver r = new SessionLocaleResolver();
        // par défaut : la langue est : français
        r.setDefaultLocale(Locale.FRENCH);
        return r;
    }
}