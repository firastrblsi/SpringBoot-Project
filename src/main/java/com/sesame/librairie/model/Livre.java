package com.sesame.librairie.model;

/**
 * Représente un livre de la bibliothèque.
 *
 * <p>C'est un simple POJO (Plain Old Java Object) : il ne contient que des
 * attributs, des accesseurs et des modifieurs. Il n'est volontairement pas
 * annoté avec JPA (@Entity, @Id) car, dans ce TP, les livres sont stockés
 * dans une liste Java en mémoire et non dans une base de données.</p>
 */
public class Livre {

    private Long id;
    private String titre;
    private String auteur;
    private int annee;

    /** Constructeur sans argument, requis par les frameworks de sérialisation. */
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