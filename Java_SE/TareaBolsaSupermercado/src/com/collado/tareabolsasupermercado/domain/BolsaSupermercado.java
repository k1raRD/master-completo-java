package com.collado.tareabolsasupermercado.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BolsaSupermercado<T> implements Iterable<T>{
    private List<T> objetos;
    private int MAX = 5;

    public BolsaSupermercado(){
        this.objetos = new ArrayList<>();
    }

    public List<T> getObjetos() {
        return objetos;
    }

    public void addObjeto(T objeto){
        if(this.objetos.size() < MAX){
            this.objetos.add(objeto);
        }else{
            throw new RuntimeException("La bolsa ya esta llena, solo resiste " + MAX + " objetos");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
