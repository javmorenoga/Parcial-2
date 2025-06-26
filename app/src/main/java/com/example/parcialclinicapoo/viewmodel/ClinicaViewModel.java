package com.example.parcialclinicapoo.viewmodel;

import android.content.Context;

import com.example.parcialclinicapoo.model.Administrador;
import com.example.parcialclinicapoo.model.Clinica;
import com.example.parcialclinicapoo.model.Consulta;
import com.example.parcialclinicapoo.model.Medico;
import com.example.parcialclinicapoo.model.Paciente;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class ClinicaViewModel {

    private static final String FILE_NAME = "clinica_data.ser";
    private static ClinicaViewModel instancia; // Singleton
    private Clinica clinica;

    // Constructor privado
    private ClinicaViewModel() {
        this.clinica = new Clinica();
    }

    // Obtener instancia única (Singleton)
    public static ClinicaViewModel getInstance() {
        if (instancia == null) {
            instancia = new ClinicaViewModel();
        }
        return instancia;
    }

    // Cargar datos desde archivo (llamar en onCreate de MainActivity)
    public void cargarDatos(Context context) {
        try {
            FileInputStream fis = context.openFileInput(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            clinica = (Clinica) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            clinica = new Clinica(); // Si no hay archivo o hay error, empezar desde cero
        }

        // ✅ Asegurar que haya al menos un administrador
        if (clinica.getAdministradores().isEmpty()) {
            Administrador admin = new Administrador("Admin General", "admin", "admin123");
            clinica.agregarAdministrador(admin);
        }
    }


    // Guardar datos en archivo (llamar después de registrar o modificar)
    public void guardarDatos(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clinica);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Registro de paciente
    public void registrarPaciente(String nombre, String id) {
        Paciente paciente = new Paciente(nombre, id);
        clinica.agregarPaciente(paciente);
    }

    // Registro de médico
    public void registrarMedico(String nombre, String id, String especialidad, String contrasena) {
        Medico medico = new Medico(nombre, id, especialidad, contrasena);
        clinica.agregarMedico(medico);
    }

    // Asignar consulta
    public void asignarConsulta(String idPaciente, String idMedico, String sintomas, String diagnostico, String tratamiento) {
        Paciente paciente = clinica.buscarPaciente(idPaciente);
        Medico medico = clinica.buscarMedico(idMedico);
        if (paciente != null && medico != null) {
            Consulta consulta = new Consulta(paciente, medico, sintomas, diagnostico, tratamiento);
            clinica.asignarConsulta(consulta);
        }
    }

    public Medico buscarMedico(String id) {
        for (Medico medico : clinica.getMedicos()) {
            if (medico.getIdentificacion().equals(id)) {
                return medico;
            }
        }
        return null;
    }
    // usuarios administradores
    public void registrarAdministrador(String nombre, String id, String contrasena) {
        Administrador admin = new Administrador(nombre, id, contrasena);
        clinica.agregarAdministrador(admin);
    }

    public Administrador buscarAdministrador(String id) {
        return clinica.buscarAdministrador(id);
    }

    public List<Administrador> getAdministradores() {
        return clinica.getAdministradores();
    }

    // Historial paciente
    public List<Consulta> historialPaciente(String idPaciente) {
        return clinica.historialPorPaciente(idPaciente);
    }

    // Consultas médico
    public List<Consulta> consultasMedico(String idMedico) {
        return clinica.consultasPorMedico(idMedico);
    }

    // Getters
    public List<Paciente> getPacientes() {
        return clinica.getPacientes();
    }

    public List<Medico> getMedicos() {
        return clinica.getMedicos();
    }

    public List<Consulta> getConsultas() {
        return clinica.getConsultas();
    }
}
