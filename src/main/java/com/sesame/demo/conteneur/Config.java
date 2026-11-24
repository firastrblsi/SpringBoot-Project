package com.sesame.demo.conteneur;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;

/**
 * Configuration Spring pour la démonstration du conteneur.
 *
 * <p>Trois beans sont déclarés avec {@link Bean} :</p>
 * <ol>
 *   <li>{@code notificateur} : retourne un {@link EmailNotificateur}, typé {@link Notificateur}</li>
 *   <li>{@code empruntService} : reçoit le notificateur par paramètre</li>
 *   <li>{@code empruntController} : reçoit le service par paramètre</li>
 * </ol>
 *
 * <p>Spring résout automatiquement les dépendances entre ces beans.</p>
 */
@Configuration
public class Config {

    @Bean
    public Notificateur notificateur() {
        System.out.println("Creation de Notificateur");
        return new EmailNotificateur();
    }

    @Bean
    public EmpruntService empruntService(Notificateur notificateur) {
        return new EmpruntService(notificateur);
    }

    @Bean
    public EmpruntController empruntController(EmpruntService empruntService) {
        return new EmpruntController(empruntService);
    }

}