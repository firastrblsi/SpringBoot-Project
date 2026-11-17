package com.sesame.librairie.controller;

import com.sesame.librairie.model.Livre;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Contrôleur REST pour les livres.
 * Base mapping: /api/livres
 */
@RestController
@RequestMapping("/api/livres")
public class LivreController {

    private final List<Livre> livres = new ArrayList<>();

    public LivreController() {
        // Initialize with 5 sample books as required by the TP
        livres.add(new Livre(1L, "Les Misérables", "Victor Hugo", 1862));
        livres.add(new Livre(2L, "Notre-Dame de Paris", "Victor Hugo", 1831));
        livres.add(new Livre(3L, "L'Étranger", "Albert Camus", 1942));
        livres.add(new Livre(4L, "La Peste", "Albert Camus", 1947));
        livres.add(new Livre(5L, "Le Petit Prince", "Antoine de Saint-Exupéry", 1943));
    }

    /**
     * GET /api/livres
     * Returns the list of all books.
     */
    @GetMapping
    public List<Livre> lister(
            @RequestParam(name = "auteur", required = false) String auteur,
            @RequestParam(name = "anneeMin", required = false) Integer anneeMin) {

        // If no filters, return all books
        if (auteur == null && anneeMin == null) {
            return livres;
        }

        // Apply filters using Java streams
        return livres.stream()
                .filter(livre -> {
                    boolean matchesAuteur = (auteur == null || livre.getAuteur().toLowerCase().contains(auteur.toLowerCase()));
                    boolean matchesAnnee = (anneeMin == null || livre.getAnnee() >= anneeMin);
                    return matchesAuteur && matchesAnnee;
                })
                .toList();
    }

    /**
     * GET /api/livres/{id}
     * Retrieves a book by ID.
     * Returns 200 OK if found, 404 Not Found if not.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Livre> trouver(@PathVariable("id") Long id) {
        return livres.stream()
                .filter(livre -> livre.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * GET /api/livres/nombre
     * Returns the count of books.
     * This is the more specific route, so Spring prioritizes it over /{id}.
     */
    @GetMapping("/nombre")
    public int nombre() {
        return livres.size();
    }
}