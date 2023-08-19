package com.k1rard.hibernateapp.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Embeddable
public class Auditoria {
    @Column(name = "creado_en")
    private LocalDateTime creadoEn;
    @Column(name = "editado_en")
    private LocalDateTime editadoEn;

    @PrePersist
    public void prePersist(){
        System.out.println("Inicalizar justo antes del persitir");
        this.creadoEn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        System.out.println("Inicializar algo antes del update");
        this.editadoEn = LocalDateTime.now();
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getEditadoEn() {
        return editadoEn;
    }

    public void setEditadoEn(LocalDateTime editadoEn) {
        this.editadoEn = editadoEn;
    }
}
