package com.example.parcialclinicapoo.model;

import java.io.Serializable;

public class Consulta implements Serializable {

    private Paciente paciente;
    private Medico medico;
    private String sintomas;
    private String diagnostico;
    private String tratamiento;

    public Consulta(Paciente paciente, Medico medico, String sintomas, String diagnostico, String tratamiento) {
        this.paciente = paciente;
        this.medico = medico;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getSintomas() {
        return sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }
}