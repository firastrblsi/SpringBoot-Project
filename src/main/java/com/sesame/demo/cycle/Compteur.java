package com.sesame.demo.cycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * Bean singleton (par défaut) avec un compteur entier.
 *
 * <p>La méthode {@link #incrementer()} incrémente et retourne la valeur.</p>
 */
@Component
public class Compteur {

    private int valeur = 0;

    public int incrementer() {
        ++valeur;
        return valeur;
    }

    @PostConstruct
    public void initialisation() {
        System.out.println("Compteur : initialisation");
    }

    @PreDestroy
    public void destruction() {
        System.out.println("Compteur : destruction");
    }

}