package com.sesame.demo.conteneur;

import com.sesame.demo.commun.Notificateur;

/**
 * Service d'emprunt avec injection de dépendance par constructeur.
 *
 * <p>Le message "Creation de EmpruntService" est affiché dans le constructeur
 * pour observer l'ordre d'initialisation dans le conteneur Spring.</p>
 */
public class EmpruntService {

    private final Notificateur notificateur;

    public EmpruntService(Notificateur notificateur) {
        this.notificateur = notificateur;
        System.out.println("Creation de EmpruntService");
    }

    public void emprunter(String etudiant, String livre) {
        System.out.println("Emprunt enregistre : " + livre);
        notificateur.envoyer(etudiant,
                "Vous avez emprunte " + livre);
    }

}