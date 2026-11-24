package com.sesame.demo.cycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

/**
 * Bean prototype : une nouvelle instance est créée à chaque demande.
 *
 * <p>Spring ne gère pas la destruction des beans prototype.</p>
 */
@Component
@Scope("prototype")
public class Ticket {

    @PostConstruct
    public void cree() {
        System.out.println("Ticket : cree");
    }

    @PreDestroy
    public void detruit() {
        System.out.println("Ticket : detruit");
    }

}