package com.sesame.demo.injection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Primary;

import com.sesame.demo.commun.Notificateur;

/**
 * Service utilisant l'injection par constructeur.
 *
 * <p>Le notificateur est injecté via le constructeur, sans {@code @Autowired}
 * car il n'y a qu'un seul constructeur.</p>
 */
@Service
public class ServiceConstructeur {

    private final Notificateur notificateur;

    public ServiceConstructeur(@Qualifier("notificateurSms") Notificateur notificateur) {
        this.notificateur = notificateur;
    }

    public String decrire() {
        return "ServiceConstructeur utilise " + notificateur.getClass().getSimpleName();
    }

}