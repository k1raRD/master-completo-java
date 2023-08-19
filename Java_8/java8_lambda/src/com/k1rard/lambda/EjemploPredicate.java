package com.k1rard.lambda;

import com.k1rard.lambda.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        Predicate<Integer> test = numero -> numero > 10;
        boolean resultado = test.test(7);
        System.out.println("resultado = " + resultado);

        Predicate<String> test2 = rol -> rol.equals("ROLE_ADMIN");
        System.out.println("test2 = " + test2.test("ROLE_USER"));

        BiPredicate<String, String> t3 = String::equals;
        System.out.println("t3 = " + t3.test("andres", "perez"));
        
        BiPredicate<Integer, Integer> t4 = (i,j) -> j > i;
        boolean r2 = t4.test(5,10);
        System.out.println("r2 = " + r2);

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("Maria");
        b.setNombre("Maria");
        BiPredicate<Usuario, Usuario> t5 = (ua, ub) -> ua.getNombre().equals(ub.getNombre());
        System.out.println(t5.test(a,b));

    }
}
