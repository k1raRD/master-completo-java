package com.k1rard.localizarmensajes;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizarMensaje {
    private static final ResourceBundle RECURSOS = ResourceBundle.getBundle("com.k1rard.localizarmensajes.vocabulario", Locale.UK);

    private static String construyendoSujeto(String nombre, String adjetivo){
        return MessageFormat.format(RECURSOS.getString("sujeto"), nombre, adjetivo);
    }

    public static void main(String[] args) {
        System.out.println(construyendoSujeto(RECURSOS.getString("manzana"), RECURSOS.getString("roja")));
        System.out.println(construyendoSujeto(RECURSOS.getString("manzana"), RECURSOS.getString("verde")));
        System.out.println(construyendoSujeto(RECURSOS.getString("pelota"), RECURSOS.getString("roja")));
        System.out.println(construyendoSujeto(RECURSOS.getString("pelota"), RECURSOS.getString("verde")));
        System.out.println(MessageFormat.format(RECURSOS.getString("frase"), construyendoSujeto(RECURSOS.getString("manzana"), RECURSOS.getString("roja"))));
    }
}
