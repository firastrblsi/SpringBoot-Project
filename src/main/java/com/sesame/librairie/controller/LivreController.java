package com.sesame.librairie.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.sesame.librairie.model.Livre;
import com.sesame.librairie.service.LivreService;

@RestController
@RequestMapping("/api/livres")
@Tag(
    name = "Livres",
    description = "Gestion des livres de la librairie"
)
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping
    public List<Livre> lister(
            @RequestParam(name = "auteur", required = false) String auteur) {
        return livreService.lister(auteur);
    }

    @GetMapping("/nombre")
    public int compter() {
        return livreService.compter();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livre> trouver(@PathVariable("id") Long id) {
        return livreService.trouver(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Livre> creer(@RequestBody Livre livre) {
        if (livre.getTitre() == null || livre.getTitre().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Livre cree = livreService.enregistrer(livre);

        URI adresse = URI.create("/api/livres/" + cree.getId());

        return ResponseEntity.created(adresse).body(cree);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livre> modifier(
            @PathVariable Long id,
            @RequestBody Livre livre) {

        return livreService.modifier(id, livre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {

        if (!livreService.supprimer(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}