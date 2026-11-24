package com.sesame.demo.commun;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

/**
 * Utilitaires pour les démonstrations du TP.
 *
 * <p>Cette classe regroupe deux méthodes statiques :</p>
 * <ul>
 *   <li>{@link #silence()} : réduit le niveau de log racine de Logback à {@code WARN}.</li>
 *   <li>{@link #beans(ApplicationContext)} : retourne la liste triée des beans applicatifs.</li>
 * </ul>
 */
public final class Outils {

    private Outils() {
        // Classe utilitaire : empêche l'instanciation.
    }

    /** Réduit le niveau du logger racine de Logback à {@code WARN} pour alléger la sortie. */
    public static void silence() {
        Logger racine = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        racine.setLevel(Level.WARN);
    }

    /**
     * Retourne la liste triée des noms de beans applicatifs.
     *
     * <p>Les noms commençant par {@code org.springframework} sont exclus pour ne
     * conserver que les beans de l'application.</p>
     *
     * @param ctx le contexte applicatif Spring
     * @return une chaîne formatée contenant les noms de beans triés
     */
    public static String beans(ApplicationContext ctx) {
        String[] noms = ctx.getBeanDefinitionNames();
        return Arrays.stream(noms)
                .filter(nom -> !nom.startsWith("org.springframework"))
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }

}