package com.educaionit.proyectoIntegregrador.models;

public class Producto {

    private Long id;
    private String nombre;
    private float precio;
    private String  descripcion;
    private String urlFoto;

    private static Long idContador = 0L;

    public Producto(Long id, String nombre, float precio, String descripcion, String urlFoto) {
        this.id= ++idContador;

        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public static Long getIdContador() {
        return idContador;
    }

    public static void setIdContador(Long idContador) {
        Producto.idContador = idContador;
    }
}
