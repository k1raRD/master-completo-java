package com.k1rard.logdiscretos;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Discretos {
    public static final Logger LOGGER = Logger.getLogger(Discretos.class.getName());
    static {
        LOGGER.setLevel(Level.WARNING);
    }

    public static void main(String[] args) {
        LOGGER.log(Level.FINEST, "Mensaje nivel Finest");
        LOGGER.info("Mensaje nivel Info");
        LOGGER.warning("Mensaje nivel Warning");
        LOGGER.severe("Mensaje nivel Severe");
        LOGGER.info(lento("Mensaje lento de generar"));
        LOGGER.severe("Fin");
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.info(lento("Mensaje que no se generará"));
        }
        LOGGER.severe("Fin definitivo");
    }

    private static String lento(String mensaje) {
        try {
            System.out.println("Generando mensaje... " + mensaje);
            Thread.sleep(2000);
            System.out.println("Mensaje generado... " + mensaje);
        } catch (InterruptedException e) {
            // nada que hacer
        }
        return mensaje;
    }
}
