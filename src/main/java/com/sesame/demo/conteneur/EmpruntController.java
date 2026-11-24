package com.sesame.demo.conteneur;

/**
 * Contrôleur d'emprunt avec injection de dépendance par constructeur.
 *
 * <p>Le message "Creation de EmpruntController" est affiché dans le constructeur
 * pour observer l'ordre d'initialisation dans le conteneur Spring.</p>
 */
public class EmpruntController {

    private final EmpruntService empruntService;

    public EmpruntController(EmpruntService empruntService) {
        this.empruntService = empruntService;
        System.out.println("Creation de EmpruntController");
    }

    public void demander(String etudiant, String livre) {
        System.out.println("Requete recue : " + livre);
        empruntService.emprunter(etudiant, livre);
    }

}