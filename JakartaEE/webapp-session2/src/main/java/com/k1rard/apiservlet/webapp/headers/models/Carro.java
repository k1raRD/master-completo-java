package com.k1rard.apiservlet.webapp.headers.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carro {
    private List<ItemCarro> items;

    public Carro() {
        this.items = new ArrayList<>();
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
