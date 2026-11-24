package com.sesame.demo.cycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sesame.demo.commun.Outils;

/**
 * Démo : scopes singleton et prototype, et cycle de vie.
 */
public class DemoCycle {

    public static void main(String[] args) {
        Outils.silence();
        System.out.println("Demarrage...");

        try (AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Config.class)) {

            System.out.println("Conteneur pret");

            Compteur a = ctx.getBean(Compteur.class);
            Compteur b = ctx.getBean(Compteur.class);
            System.out.println("a == b : " + (a == b));

            a.incrementer();
            a.incrementer();
            System.out.println("Valeur lue via b : " + b.incrementer());

            Ticket t1 = ctx.getBean(Ticket.class);
            Ticket t2 = ctx.getBean(Ticket.class);
            System.out.println("t1 == t2 : " + (t1 == t2));

            System.out.println("Fermeture du conteneur...");
        }

        System.out.println("Termine");
    }

}