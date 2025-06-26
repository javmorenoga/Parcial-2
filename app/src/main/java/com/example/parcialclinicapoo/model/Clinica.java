package com.example.parcialclinicapoo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clinica implements Serializable {

    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    private List<Administrador> administradores;


    public Clinica() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        consultas = new ArrayList<>();
        administradores = new ArrayList<>();
    }

    // Registrar paciente
    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    // Registrar médico
    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    // Buscar paciente por ID
    public Paciente buscarPaciente(String id) {
        for (Paciente p : pacientes) {
            if (p.getIdentificacion().equals(id)) return p;
        }
        return null;
    }

    // Buscar médico por ID
    public Medico buscarMedico(String id) {
        for (Medico m : medicos) {
            if (m.getIdentificacion().equals(id)) return m;
        }
        return null;
    }

    // Registrar consulta
    public void asignarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    // Historial por paciente
    public List<Consulta> historialPorPaciente(String idPaciente) {
        List<Consulta> resultado = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getPaciente().getIdentificacion().equals(idPaciente)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    // Consultas por médico
    public List<Consulta> consultasPorMedico(String idMedico) {
        List<Consulta> resultado = new ArrayList<>();
        for (Consulta c : consultas) {
            if (c.getMedico().getIdentificacion().equals(idMedico)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public Administrador buscarAdministrador(String id) {
        for (Administrador admin : administradores) {
            if (admin.getIdentificacion().equals(id)) {
                return admin;
            }
        }
        return null;
    }

    public void agregarAdministrador(Administrador administrador) {
        administradores.add(administrador);
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }
    // Getters para las listas completas (opcional)
    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }
}
