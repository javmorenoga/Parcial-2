package com.example.parcialclinicapoo.model;

public class Medico extends Persona {

    private String especialidad;
    private String contrasena;

    public Medico(String nombre, String identificacion, String especialidad, String contrasena) {
        super(nombre, identificacion);
        this.especialidad = especialidad;
        this.contrasena = contrasena;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getContrasena(){
        return contrasena;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String getTipo() {
        return "Medico";
    }


    @Override
    public String toString() {
        return "Nombre: " + getNombre() +
                "\nID: " + getIdentificacion() +
                "\nEspecialidad: " + especialidad +
                "\nContraseña: " + contrasena;
    }
}
