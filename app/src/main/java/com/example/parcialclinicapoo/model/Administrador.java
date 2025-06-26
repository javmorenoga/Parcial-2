package com.example.parcialclinicapoo.model;

public class Administrador extends Persona {

    private String contrasena;

    public Administrador(String nombre, String identificacion, String contrasena) {
        super(nombre, identificacion);
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    @Override
    public String getTipo() {
        return "Administrador";
    }
}