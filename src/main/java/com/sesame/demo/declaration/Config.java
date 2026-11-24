package com.sesame.demo.declaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesame.demo.commun.EmailNotificateur;
import com.sesame.demo.commun.Notificateur;
import com.sesame.demo.commun.SmsNotificateur;

/**
 * Configuration Spring démontrant la déclaration de beans avec {@link Bean}.
 *
 * <p>Deux beans de type {@link Notificateur} sont déclarés dans un même
 * conteneur pour montrer que plusieurs beans du même type peuvent coexister.</p>
 */
@Configuration
public class Config {

    /**
     * Bean email. Le nom par défaut est {@code notificateur}.
     */
    @Bean
    public Notificateur notificateur() {
        return new EmailNotificateur();
    }

    /**
     * Bean SMS. Le nom est explicitement fixé à {@code alerteSms}.
     */
    @Bean(name = "alerteSms")
    public Notificateur sms() {
        return new SmsNotificateur();
    }

}