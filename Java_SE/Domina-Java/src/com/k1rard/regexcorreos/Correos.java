package com.k1rard.regexcorreos;
import java.util.regex.Pattern;

public class Correos {

    private static final String PATRON_SIMPLE = "^(.+)@(\\S+)$";

    private static final String PATRON_ESTRICTO = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*"
            + "@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    private static final String PATRON_RFC = "^[a-zA-Z0-9_!#$%&*+/=?`{}~^.-]+"
            + "@[a-zA-Z0-9.-]+$";

    private static final String PATRON_OWASP = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*"
            + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";

    private static final String[] PATRONES = {PATRON_SIMPLE, PATRON_ESTRICTO, PATRON_RFC, PATRON_OWASP};

    private static final String MAIL_0 = "nombre#dominio.es";
    private static final String MAIL_1 = "nombre@dominio.es";
    private static final String MAIL_2 = "nombre.apellido@dominio.es";
    private static final String MAIL_3 = "nombre@apellido@dominio@es";
    private static final String MAIL_4 = "niño@dominio.es";
    private static final String MAIL_5 = "nombre.apellido.@dominio.es";
    private static final String MAIL_6 = "francisco-javier.gonzalez-del-olmo.rodriguez-de-la-pradera.director-general@empresa.com";
    private static final String MAIL_7 = "a@b.c";
    private static final String MAIL_8 = "a@bb.cc";
    private static final String MAIL_9 = "a?b:c'd#e@bb.cc";

    private static final String[] MAILS = { MAIL_0, MAIL_1, MAIL_2, MAIL_3, MAIL_4, MAIL_5, MAIL_6, MAIL_7, MAIL_8,
            MAIL_9 };
    public static void main(String[] args) {
        for (String patron : PATRONES) {
            System.out.println("PATRON: " + patron);
            for (String mail : MAILS) {
                System.out.print("\t" + Pattern.matches(patron, mail));
                System.out.println("\t" + mail);
            }
            System.out.println();
        }
    }
}

