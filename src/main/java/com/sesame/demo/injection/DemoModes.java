package com.sesame.demo.injection;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sesame.demo.commun.Outils;

/**
 * Démo : modes d'injection (constructeur, setter, champ) avec Spring.
 */
public class DemoModes {

    public static void main(String[] args) {
        Outils.silence();

        try (AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Config.class)) {

            ServiceConstructeur serviceConstructeur = ctx.getBean(ServiceConstructeur.class);
            ServiceSetter serviceSetter = ctx.getBean(ServiceSetter.class);
            ServiceChamp serviceChamp = ctx.getBean(ServiceChamp.class);

            System.out.println(serviceConstructeur.decrire());
            System.out.println(serviceSetter.decrire());
            System.out.println(serviceChamp.decrire());
        }
    }

}