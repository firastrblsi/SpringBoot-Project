package com.sesame.demo.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesame.demo.commun.Notificateur;

/**
 * Service utilisant l'injection par champ (field injection).
 *
 * <p>Démontre les inconvénients de l'injection par champ.</p>
 */
@Service
public class ServiceChamp {

    @Autowired
    private Notificateur notificateur;

    public String decrire() {
        return "ServiceChamp utilise " + notificateur.getClass().getSimpleName();
    }

}