package com.sesame.demo.commun;

/**
 * Implémentation d'un service de notification par SMS.
 *
 * <p>Cette classe simule un envoi de SMS. La méthode {@link #envoyer(String, String)}
 * affiche un message formaté en sortie standard.</p>
 */
public class SmsNotificateur implements Notificateur {

    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[SMS] vers " + destinataire + " : " + message);
    }

}