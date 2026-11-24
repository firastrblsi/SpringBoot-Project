package com.sesame.demo.stereotypes;

import org.springframework.stereotype.Component;

import com.sesame.demo.commun.Notificateur;

/**
 * Implémentation d'un notificateur par e-mail, découvert automatiquement par
 * le scan de composants de Spring.
 */
@Component
public class NotificateurEmail implements Notificateur {

    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[EMAIL] vers " + destinataire + " : " + message);
    }

}