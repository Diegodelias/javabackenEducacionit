package com.educaionit.proyectoIntegregrador.models;

public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private Direccion direccion;
    private String telefono;

    private int edad;

    private String email;

    private static Long idContador = 0L;

    public Persona(String nombre, String apellido, Direccion direccion, String telefono, int edad, String email) {
        this.id= ++idContador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.email = email;

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Long getIdContador() {
        return idContador;
    }

    public static void setIdContador(Long idContador) {
        Persona.idContador = idContador;
    }
}
