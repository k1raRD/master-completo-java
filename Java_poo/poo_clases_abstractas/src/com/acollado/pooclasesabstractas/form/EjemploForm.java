package com.acollado.pooclasesabstractas.form;

import com.acollado.pooclasesabstractas.form.elementos.ElementoForm;
import com.acollado.pooclasesabstractas.form.elementos.InputForm;
import com.acollado.pooclasesabstractas.form.elementos.SelectForm;
import com.acollado.pooclasesabstractas.form.elementos.TextAreaForm;
import com.acollado.pooclasesabstractas.form.elementos.select.Opcion;
import com.acollado.pooclasesabstractas.form.validador.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        username.addValidador(new RequeridoValidador());

        InputForm password = new InputForm("clave", "password");
        password.addValidador(new RequeridoValidador())
                .addValidador(new LargoValidador(6, 12));

        InputForm email = new InputForm("email", "email");
        email.addValidador(new RequeridoValidador())
                .addValidador(new EmailValidador());

        InputForm edad = new InputForm("edad", "number");
        edad.addValidador(new NumeroValidador());

        TextAreaForm experiencia = new TextAreaForm("exp", 5, 9);

        SelectForm lenguaje = new SelectForm("lenguaje");
        lenguaje.addValidador(new NoNuloValidador());
        Opcion java = new Opcion("1", "java");
//        Opcion typeScript = new Opcion("4", "TypeScript");
        lenguaje.addOpcion(java)
                .addOpcion(new Opcion("2", "Python"))
                .addOpcion(new Opcion("3", "Jvascript"))
                .addOpcion(new Opcion("4", "TypeScript").setSelected())
                .addOpcion(new Opcion("5", "PHP"));

        ElementoForm saludar = new ElementoForm("Saludo") {
            @Override
            public String dibujarHtml() {
                return "<input disabled name='" + this.nombre + "' value=\"" + this.valor + "\"/>";
            }
        };

        saludar.setValor("Hola que tal este camp esta deshabilitado!");
        username.setValor("k1rard");
        password.setValor("123");
        email.setValor("k1rard23@gmail.com");
        edad.setValor("21l");
        experiencia.setValor("La verdad es que creo que java es un muy buen lenguaje");
//        java.setSelected(true);
//        typeScript.setSelected(true);
        List<ElementoForm> elementos = Arrays.asList(username,
                password,
                email,
                edad,
                experiencia,
                lenguaje,
                saludar);

//        for (ElementoForm e : elementos) {
//            System.out.println(e.dibujarHtml());
//            System.out.println("<br>");
//        }
        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        elementos.forEach(e -> {
            if(!e.esValido()){
                e.getErrores().forEach(System.out::println);
            }
        });

    }
}
