package com.acollado.generics;

import com.acollado.poointerfaces.modelo.Cliente;
import com.acollado.poointerfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes= new ArrayList<Cliente>();
        clientes.add(new Cliente("Andres", "Guzman"));
        Cliente andres = clientes.iterator().next();

        Cliente[] clientesArreglo = {new Cliente("luci", "martinez"),
                new Cliente("Andres", "Guzman")};
        Integer[] enteros = {1,2,3,45,};

        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
        List<Integer> enterosLista = fromArrayToList(enteros);

        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Andres", "Pepe", "Bea"}, enteros);

        List<ClientePremium> clientePremiumList = fromArrayToList(
                new ClientePremium[]{new ClientePremium("Paco", "Fernandez")});

        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientePremiumList);

        System.out.println("Mximo de 1, 9 y 4 es: " + maximo(1, 9,4));
        System.out.println("Maximo de 3.9, 11.6, 7.78 es: " + maximo(3.9, 11.6,7.78));
        System.out.println("Maximo de Zanahoria, Arandanos, Manzana es: " +
                maximo("Zanahoria", "Arandanos", "Manzana"));
    }

    public static <T extends Number> List<T> fromArrayToList(T[] clientes){
        return Arrays.asList(clientes);
    }

    public static <T> List<T> fromArrayToList(T[] clientes){
        return Arrays.asList(clientes);
    }
//    public static List<Cliente> fromArrayToList(Cliente[] clientes){
//        return Arrays.asList(clientes);
//    }

    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] clientes){
        return Arrays.asList(clientes);
    }

    public static <T, G> List<T> fromArrayToList(T[] c, G[] g){
        for(G elemento: g){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes){
        clientes.forEach(System.out::println);
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c){
        T max = a;
        if(b.compareTo(max) > 0){
            max = b;
        }
        if(c.compareTo(max) > 0){
            max = c;
        }
        return max;
    }
}
