package com.k1rard.ejemplos.map;

import com.k1rard.ejemplos.modelo.Alumno;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EjemploHashMap {
    public static void main(String[] args) {

        Map<String, Object> persona = new HashMap<>();
        persona.put(null, "1234");
        persona.put("nombre", "John");
        persona.put("apellido", "Doe");
        persona.put("apellidoPaterno", "Doe");
        persona.put("email", "jhon.Doe@gmail.com");
        persona.put("edad", 30);

        Map<String, String> direccion = new HashMap<>();
        direccion.put("pais", "USA");
        direccion.put("estado", "California");
        direccion.put("ciudad", "Santa Barbara");
        direccion.put("calle", "Wall Street");
        direccion.put("numero", "120");

        persona.put("direccion", direccion);

        System.out.println("persona = " + persona);

        String nombre = (String) persona.get("nombre");
        System.out.println("nombre = " + nombre);
        String apellido = (String) persona.get("apellido");
        System.out.println("apellido = " + apellido);

        Map<String, String> direccionPersona = (Map<String, String>) persona.get("direccion");
        String pais = direccionPersona.get("pais");
        String ciudad = direccionPersona.get("ciudad");
        String barrio = direccionPersona.getOrDefault("barrio", "La playa");
        System.out.println("El pais de " + nombre +" es: " + pais);
        System.out.println("La ciudad de " + nombre +" es: " + ciudad);
        System.out.println("El barrio de " + nombre +" es: " + barrio);

        String valorApellido = (String) persona.remove("apellidoPaterno");
//        boolean valorApellido = persona.remove("apellidoPaterno", "Roe");
        System.out.println("Eliminado = " + valorApellido);
        System.out.println("persona = " + persona);
        
        boolean b = persona.containsKey("apellidoPaterno");
        System.out.println("b = " + b);

        b = persona.containsValue("Doe");
        System.out.println("b = " + b);

        Collection<Object> values = persona.values();
        for(Object valor: values){
            System.out.println("valor = " + valor);
        }

        System.out.println("=================================keySet");
        Set<String> llaves = persona.keySet();
        for (String llave: llaves){
            System.out.println("llave = " + llave);
        }

        System.out.println("=================================entrySet");
        for(Map.Entry<String, Object> par: persona.entrySet()){
            Object valor = par.getValue();
            if (valor instanceof Map){
                Map<String, String> direccionMap = (Map<String, String>) valor;
                String nom = (String) persona.get("nombre");
                System.out.println("El pais de " + nom + ": "
                        + direccionMap.get("pais"));
                System.out.println("La ciudad de " + nom + ": "
                        + direccionMap.get("ciudad"));
                System.out.println("El estado de " + nom + ": "
                        + direccionMap.get("estado"));
            }else{
                System.out.println(par.getKey() + " => " + valor);
            }
        }

        System.out.println("=================================entrySet for anidado");
        for(Map.Entry<String, Object> par: persona.entrySet()){
            Object valor = par.getValue();
            if (valor instanceof Map){
                Map<String, String> direccionMap = (Map<String, String>) valor;
                for(Map.Entry<String, String> entry: direccionMap.entrySet()){
                    System.out.println(entry.getKey() + " => " + entry.getValue());
                }
            }else{
                System.out.println(par.getKey() + " => " + valor);
            }
        }

        System.out.println("=================================keySet");
        for(String llave: persona.keySet()){
            Object valor =  persona.get(llave);
            if (valor instanceof Map){
                Map<String, String> direccionMap = (Map<String, String>) valor;
                String nom = (String) persona.get("nombre");
                System.out.println("El pais de " + nom + ": "
                        + direccionMap.get("pais"));
                System.out.println("La ciudad de " + nom + ": "
                        + direccionMap.get("ciudad"));
                System.out.println("El estado de " + nom + ": "
                        + direccionMap.get("estado"));
            }else{
                System.out.println(llave + " => " + valor);
            }
        }

        System.out.println("=================================Java8 foreach");
        persona.forEach((llave, valor) -> System.out.println(llave + " => " + valor));

        System.out.println("Total: " + persona.size());
        System.out.println("Contiene elementos: " + !persona.isEmpty());

        //persona.replace("nombre", "Andres");
        boolean b2 = persona.replace("nombre", "Juan" ,"Andres");
        System.out.println(b2);
        System.out.println("persona = " + persona);
    }
}
