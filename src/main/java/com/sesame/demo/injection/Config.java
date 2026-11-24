package com.sesame.demo.injection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration Spring pour les démonstrations des modes d'injection.
 *
 * <p>Le scan de composants couvre le package {@code com.sesame.demo.injection}
 * et découvre les services et notificateurs annotés.</p>
 */
@Configuration
@ComponentScan
public class Config {

}