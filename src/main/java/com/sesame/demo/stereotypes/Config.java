package com.sesame.demo.stereotypes;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration Spring utilisant le scan de composants (@ComponentScan) pour
 * découvrir automatiquement les beans annotés dans le package
 * {@code com.sesame.demo.stereotypes} et ses sous-packages.
 */
@Configuration
@ComponentScan
public class Config {

}