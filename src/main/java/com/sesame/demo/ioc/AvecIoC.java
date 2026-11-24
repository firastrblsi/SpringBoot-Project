package com.sesame.demo.ioc;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;
import com.sesame.demo.commun.SmsNotificateur;

/**
 * Démo : inversion de contrôle avec conteneur Spring (injection via constructeur).
 *
 * <p>Le service {@code EmpruntService} dépend de l'interface {@link Notificateur}
 * et reçoit l'implémentation choisie via son constructeur. Aucune instanciation
 * interne du notifier n'est faite dans le service.</p>
 */
public class AvecIoC {

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

    public static void main(String[] args) {
        EmpruntService serviceEmail = new EmpruntService(new EmailNotificateur());
        serviceEmail.emprunter("amine@sesame.tn", "Clean Code");

        EmpruntService serviceSms = new EmpruntService(new SmsNotificateur());
        serviceSms.emprunter("amine@sesame.tn", "Clean Code");
    }

}