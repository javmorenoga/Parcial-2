package com.example.parcialclinicapoo.model;

public class Paciente  extends Persona{

    public Paciente(String nombre, String identificacion){
        super(nombre, identificacion);
    }

    @Override
    public String getTipo(){
        return "Paciente";
    }

}
