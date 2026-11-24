package com.sesame.demo.declaration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sesame.demo.commun.Notificateur;
import com.sesame.demo.commun.Outils;

/**
 * Démo : déclaration de beans avec {@code @Bean} et nommage.
 *
 * <p>Deux beans de type {@link Notificateur} sont créés. Ils sont récupérés
 * par leur nom explicite pour démontrer le mécanisme de nommage des beans.</p>
 */
public class DemoDeclaration {

    public static void main(String[] args) {
        Outils.silence();

        try (AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Config.class)) {

            System.out.println("Beans : " + Outils.beans(ctx));

            Notificateur email = ctx.getBean("notificateur", Notificateur.class);
            email.envoyer("amine@sesame.tn", "Bienvenue");

            Notificateur sms = ctx.getBean("alerteSms", Notificateur.class);
            sms.envoyer("amine@sesame.tn", "Bienvenue");
        }
    }

}