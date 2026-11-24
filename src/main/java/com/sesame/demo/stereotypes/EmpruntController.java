package com.sesame.demo.stereotypes;

import org.springframework.stereotype.Controller;

import com.sesame.demo.commun.Notificateur;

/**
 * Contrôleur d'emprunt. C'est une démonstration console, pas un contrôleur REST.
 *
 * <p>Il dépend du service d'emprunt injecté par son constructeur.</p>
 */
@Controller
public class EmpruntController {

    private final EmpruntService empruntService;

    public EmpruntController(EmpruntService empruntService) {
        this.empruntService = empruntService;
    }

    public void demander(String etudiant, String livre) {
        System.out.println("Requete recue : " + livre);
        empruntService.emprunter(etudiant, livre);
    }

}