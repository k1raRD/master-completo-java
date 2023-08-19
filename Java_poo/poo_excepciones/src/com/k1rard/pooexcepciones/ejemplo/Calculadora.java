package com.k1rard.pooexcepciones.ejemplo;

public class Calculadora {

    public double dividir(int numerador, int denominador) throws DivisionPorZeroException {
        if (denominador == 0){
            throw new DivisionPorZeroException("La division entre 0 no es permitida");
        }
        return numerador / (double) denominador;
    }

    public double dividir(String numerador, String denominador)
            throws DivisionPorZeroException, NumeroFormatoException {
       try {
           int num = Integer.parseInt(numerador);
           int div = Integer.parseInt(denominador);
           return this.dividir(num, div);
       }catch (NumberFormatException e){
           throw new NumeroFormatoException("Debe ingresar un numero en el numerador y en el denominador");
       }

    }
}
