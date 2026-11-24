package com.sesame.demo.conteneur;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sesame.demo.commun.Outils;

/**
 * Démo : démarrage du conteneur Spring et injection de dépendances.
 *
 * <p>Utilise {@link AnnotationConfigApplicationContext} avec la classe
 * de configuration {@link Config}. Le contexte est géré avec try-with-resources
 * pour garantir sa fermeture.</p>
 */
public class DemoConteneur {

    public static void main(String[] args) {
        Outils.silence();
        System.out.println("Demarrage du conteneur...");

        try (AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Config.class)) {

            System.out.println("Conteneur pret. Beans : " + Outils.beans(ctx));

            EmpruntController controller = ctx.getBean(EmpruntController.class);
            controller.demander("amine@sesame.tn", "Clean Code");
        }
    }

}