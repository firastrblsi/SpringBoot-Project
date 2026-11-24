package com.sesame.demo.stereotypes;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sesame.demo.commun.Outils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Controller;

/**
 * Démo : stéréotypes et scan de composants Spring.
 *
 * <p>Démontre comment Spring découvre automatiquement les beans annotés avec
 * {@code @Controller}, {@code @Service} et {@code @Repository}, et que
 * {@code @Service} est lui-même annoté par {@code @Component}.</p>
 */
public class DemoStereotypes {

    public static void main(String[] args) {
        Outils.silence();

        try (AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(Config.class)) {

            System.out.println("Beans : " + Outils.beans(ctx));

            System.out.println("@Controller : "
                    + Arrays.toString(ctx.getBeanNamesForAnnotation(Controller.class)));
            System.out.println("@Service : "
                    + Arrays.toString(ctx.getBeanNamesForAnnotation(Service.class)));
            System.out.println("@Repository : "
                    + Arrays.toString(ctx.getBeanNamesForAnnotation(Repository.class)));

            System.out.println("@Service est une @Component : "
                    + Service.class.isAnnotationPresent(Component.class));

            try {
                EmpruntController controller = ctx.getBean(EmpruntController.class);
                controller.demander("amine@sesame.tn", "Clean Code");
            } catch (BeansException ex) {
                System.out.println("Erreur : " + ex.getCause());
            }
        }
    }

}