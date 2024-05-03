package com.example.parcial2.clases;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String imagen;
    private String nombre;
    private String Descripcion;
    private String estado;
    private String planeta;
    private String genero;
    private String ubicacion;

    public Usuario(String imagen, String nombre, String descripcion,String estado,String planeta,String genero,String ubicacion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.Descripcion = descripcion;
        this.estado = estado;
        this.planeta= planeta;
        this.genero= genero;
        this.ubicacion= ubicacion;

    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        estado = estado;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
