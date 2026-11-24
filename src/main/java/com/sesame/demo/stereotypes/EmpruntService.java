package com.sesame.demo.stereotypes;

import org.springframework.stereotype.Service;

import com.sesame.demo.commun.Notificateur;

/**
 * Service d'emprunt géré par Spring avec injection de dépendances par
 * constructeur.
 *
 * <p>Il dépend du dépôt d'emprunts et d'un notificateur. Les deux dépendances
 * sont injectées par le constructeur et stockées dans des champs {@code final}.</p>
 */
@Service
public class EmpruntService {

    private final EmpruntRepository empruntRepository;
    private final Notificateur notificateur;

    public EmpruntService(EmpruntRepository empruntRepository, Notificateur notificateur) {
        this.empruntRepository = empruntRepository;
        this.notificateur = notificateur;
    }

    public void emprunter(String etudiant, String livre) {
        empruntRepository.ajouter(livre);
        System.out.println("Emprunt enregistre : " + livre
                + " (" + empruntRepository.nombre() + " emprunt(s) en memoire)");
        notificateur.envoyer(etudiant,
                "Vous avez emprunte " + livre);
    }

}