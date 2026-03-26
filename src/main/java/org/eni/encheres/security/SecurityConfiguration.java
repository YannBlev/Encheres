package org.eni.encheres.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/encheres/profils", "/encheres/profils/**", "/encheres/categorie","/encheres/categorie/**").hasRole("admin")
                        .requestMatchers("/profil").authenticated()
                        .requestMatchers("/profil/nouveauProfil").permitAll()
                        .requestMatchers("/profil/**").permitAll()
                        .requestMatchers("/**").permitAll())

                .httpBasic(Customizer.withDefaults())
                .formLogin((formLogin) -> formLogin
                        .loginPage("/encheres/login")
                        .loginProcessingUrl("/encheres/login")
                        .failureUrl("/encheres/login?error=true")
                        .defaultSuccessUrl("/encheres", true)
                        .permitAll()
                )
                .logout((logout) -> logout.logoutSuccessUrl("/")
                                .logoutUrl("/logout")                  // route qui déclenche le logout
                                .invalidateHttpSession(true)           // invalide la session
                                .deleteCookies("JSESSIONID")           // supprime le cookie de session
                                .clearAuthentication(true)             // efface le SecurityContext
                        );

        return http.build();
    }

    @Bean // on définit un bean pour l'utilitaire d'encryption de mot de passe
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
