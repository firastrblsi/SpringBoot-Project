package com.sesame.demo.ioc;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;

/**
 * Démo : inversion de contrôle sans conteneur.
 *
 * <p>Dans cette démonstration, le service {@code EmpruntService} crée lui-même
 * son dépendance ({@link EmailNotificateur}) avec {@code new}. C'est un exemple
 * de couplage fort.</p>
 */
public class SansIoC {

    public static class EmpruntService {

        private final EmailNotificateur notificateur = new EmailNotificateur();

        public void emprunter(String etudiant, String livre) {
            System.out.println("Emprunt enregistre : " + livre);
            notificateur.envoyer(etudiant,
                    "Vous avez emprunte " + livre);
        }
    }

    public static void main(String[] args) {
        EmpruntService service = new EmpruntService();
        service.emprunter("amine@sesame.tn", "Clean Code");
    }

}