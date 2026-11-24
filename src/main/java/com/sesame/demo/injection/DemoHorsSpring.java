package com.sesame.demo.injection;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;

/**
 * Démo : injection sans Spring.
 *
 * <p>Le service à injection par constructeur est instancié manuellement et
 * reçoit un {@link Notificateur} via son constructeur. Le service à injection
 * par champ n'est pas initialisé : Spring ne s'exécute pas, donc le champ
 * reste {@code null} et provoque une {@link NullPointerException}.</p>
 */
public class DemoHorsSpring {

    public static void main(String[] args) {
        ServiceConstructeur serviceConstructeur = new ServiceConstructeur(new EmailNotificateur());
        System.out.println("Constructeur : " + serviceConstructeur.decrire());

        ServiceChamp serviceChamp = new ServiceChamp();
        try {
            serviceChamp.decrire();
        } catch (NullPointerException ex) {
            System.out.println("Champ : NullPointerException");
        }
    }

}