package com.example.parcialclinicapoo.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcialclinicapoo.R;

public class MainAdminActivity extends AppCompatActivity {

    private Button buttonRegistroPaciente, buttonRegistroMedico, buttonListaPacientes,
            buttonListaMedicos, buttonAsignarConsulta, buttonHistorialPaciente, buttonConsultasMedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        buttonRegistroPaciente = findViewById(R.id.buttonRegistroPaciente);
        buttonRegistroMedico = findViewById(R.id.buttonRegistroMedico);
        buttonListaPacientes = findViewById(R.id.buttonListaPacientes);
        buttonListaMedicos = findViewById(R.id.buttonListaMedicos);
        buttonAsignarConsulta = findViewById(R.id.buttonAsignarConsulta);
        buttonHistorialPaciente = findViewById(R.id.buttonHistorialPaciente);
        buttonConsultasMedico = findViewById(R.id.buttonConsultasMedico);

        buttonRegistroPaciente.setOnClickListener(v -> startActivity(new Intent(this, RegistroPacienteActivity.class)));
        buttonRegistroMedico.setOnClickListener(v -> startActivity(new Intent(this, RegistroMedicoActivity.class)));
        buttonListaPacientes.setOnClickListener(v -> startActivity(new Intent(this, ListaPacientesActivity.class)));
        buttonListaMedicos.setOnClickListener(v -> startActivity(new Intent(this, ListaMedicosActivity.class)));
        buttonAsignarConsulta.setOnClickListener(v -> startActivity(new Intent(this, AsignarConsultaActivity.class)));
        buttonHistorialPaciente.setOnClickListener(v -> startActivity(new Intent(this, HistorialPacienteActivity.class)));
        buttonConsultasMedico.setOnClickListener(v -> startActivity(new Intent(this, ConsultasMedicoActivity.class)));
    }
}
