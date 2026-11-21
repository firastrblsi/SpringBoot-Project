package com.sesame.librairie.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Représente un livre de la bibliothèque.
 *
 * <p>C'est une entité JPA (JPA Entity) qui est persistée dans la base de données
 * H2 via Spring Data JPA et Hibernate.</p>
 */
@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titre;

    private String auteur;

    private int annee;

    /** Constructeur sans argument, requis par JPA. */
    public Livre() {
    }

    /** Constructeur avec tous les attributs. */
    public Livre(Long id, String titre, String auteur, int annee) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
