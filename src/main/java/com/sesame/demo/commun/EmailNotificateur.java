package com.sesame.demo.commun;

/**
 * Implémentation d'un service de notification par e-mail.
 *
 * <p>Cette classe simulate un envoi d'e-mail. La méthode {@link #envoyer(String, String)}
 * affiche un message formaté en sortie standard.</p>
 */
public class EmailNotificateur implements Notificateur {

    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[EMAIL] vers " + destinataire + " : " + message);
    }

}