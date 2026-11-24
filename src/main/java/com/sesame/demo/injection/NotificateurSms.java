package com.sesame.demo.injection;

import org.springframework.stereotype.Component;

import com.sesame.demo.commun.Notificateur;

/**
 * Notificateur par SMS, avec composante Spring ({@link Component}),
 * ajouté pour démontrer l'ambiguïté des beans.
 */
@Component
public class NotificateurSms implements Notificateur {

    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[SMS] vers " + destinataire + " : " + message);
    }

}