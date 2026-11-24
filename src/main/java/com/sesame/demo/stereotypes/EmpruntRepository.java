package com.sesame.demo.stereotypes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * Dépôt d'emprunts en mémoire (sans base de données réelle).
 *
 * <p>Stocke les titres des livres empruntés dans une liste {@code List<String>}</p>
 */
@Repository
public class EmpruntRepository {

    private final List<String> emprunts = new ArrayList<>();

    public void ajouter(String livre) {
        emprunts.add(livre);
    }

    public int nombre() {
        return emprunts.size();
    }

}