package com.sesame.demo.commun;

/**
 * Service de notification.
 *
 * <p>Cette interface définit le contrat sans préciser comment les notifications
 * sont envoyées. Elle est utilisée pour démontrer l'inversion de contrôle et
 * l'injection de dépendances.</p>
 */
public interface Notificateur {

    /**
     * Envoie un message à un destinataire.
     *
     * @param destinataire l'adresse du destinataire (par exemple, un e-mail)
     * @param message le message à envoyer
     */
    void envoyer(String destinataire, String message);

}