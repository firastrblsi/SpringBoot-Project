package com.sesame.demo.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesame.demo.commun.Notificateur;

/**
 * Service utilisant l'injection par setter.
 */
@Service
public class ServiceSetter {

    @Autowired
    private Notificateur notificateur;

    public void setNotificateur(Notificateur notificateur) {
        this.notificateur = notificateur;
    }

    public String decrire() {
        return "ServiceSetter utilise " + notificateur.getClass().getSimpleName();
    }

}