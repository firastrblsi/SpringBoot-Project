package com.sesame.demo.injection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.sesame.demo.commun.Notificateur;

/**
 * Notificateur par e-mail, avec composante Spring ({@link Component}),
 * marqué {@code @Primary} pour résoudre l'ambiguïté avec {@link NotificateurSms}.
 */
@Component
@Primary
public class NotificateurEmail implements Notificateur {

    @Override
    public void envoyer(String destinataire, String message) {
        System.out.println("[EMAIL] vers " + destinataire + " : " + message);
    }

}