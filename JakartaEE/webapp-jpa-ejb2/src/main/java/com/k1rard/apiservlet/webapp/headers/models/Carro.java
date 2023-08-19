package com.k1rard.apiservlet.webapp.headers.models;

import com.k1rard.apiservlet.webapp.headers.config.*;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@CarroCompra
public class Carro implements Serializable {
    private List<ItemCarro> items;

    @Inject
    private transient Logger log;

    @PostConstruct
    public void inicializar(){
        this.items = new ArrayList<>();
        log.info("Inicializando el carro de compras");
    }

    @PreDestroy
    public void destruir(){
        log.info("Destruyendo el carro de compras!");
    }

    public void addItem(ItemCarro item){
        if(items.contains(item)){
            Optional<ItemCarro> itemCarroOptional = items.stream()
                    .filter(a -> a.equals(item))
                    .findAny();
            if(itemCarroOptional.isPresent()){
                ItemCarro i = itemCarroOptional.get();
                i.setCantidad(i.getCantidad() + 1);
            }
        }else{
            this.items.add(item);
        }
    }

    public List<ItemCarro> getItems() {
        return items;
    }

    public int getTotal(){
        return items.stream().mapToInt(ItemCarro::getImporte).sum();
    }

    public void removeItem(ItemCarro item){
        if(this.items.contains(item)){
            Optional<ItemCarro> itemCarroOptional = items.stream()
                    .filter(a -> a.equals(item))
                    .findAny();
            if(itemCarroOptional.isPresent()){
                ItemCarro i = itemCarroOptional.get();
                if(i.getCantidad() == 1){
                    this.items.remove(i);
                }else{
                    i.setCantidad(i.getCantidad() - 1);
                }
            }
        }
    }
}
