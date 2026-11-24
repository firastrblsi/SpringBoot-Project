package com.sesame.demo.di;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;

/**
 * Démo : injection de dépendances manuelle (sans Spring).
 *
 * <p>La chaîne de dépendances est assemblée manuellement dans le bon ordre :</p>
 * <pre>
 * EmailNotificateur
 *        ↓
 * EmpruntService
 *        ↓
 * EmpruntController
 * </pre>
 */
public class DemoInjection {

    public static class EmpruntService {

        private final Notificateur notificateur;

        public EmpruntService(Notificateur notificateur) {
            this.notificateur = notificateur;
        }

        public void emprunter(String etudiant, String livre) {
            System.out.println("Emprunt enregistre : " + livre);
            notificateur.envoyer(etudiant,
                    "Vous avez emprunte " + livre);
        }
    }

    public static class EmpruntController {

        private final EmpruntService empruntService;

        public EmpruntController(EmpruntService empruntService) {
            this.empruntService = empruntService;
        }

        public void demander(String etudiant, String livre) {
            System.out.println("Requete recue : " + livre);
            empruntService.emprunter(etudiant, livre);
        }
    }

    public static void main(String[] args) {
        EmailNotificateur notificateur = new EmailNotificateur();
        EmpruntService empruntService = new EmpruntService(notificateur);
        EmpruntController empruntController = new EmpruntController(empruntService);

        empruntController.demander("amine@sesame.tn", "Clean Code");
    }

}