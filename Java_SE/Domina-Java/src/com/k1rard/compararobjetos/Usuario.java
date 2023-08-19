package com.k1rard.compararobjetos;

import java.util.Objects;

public class Usuario implements Comparable<Usuario> {
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    public Usuario(String nombre, String apellido, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido) && Objects.equals(email, usuario.email) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, email, password);
    }

    @Override
    public int compareTo(Usuario o) {
        if(o == null || !(o instanceof  Usuario))
            return 1;

        Usuario u = (Usuario) o;
        int compNom = nombre.compareTo(u.nombre);
        if (compNom != 0)
            return compNom;

        int compApellido = apellido.compareTo(u.apellido);
        return -compApellido;
    }
}
