package com.example.parcialclinicapoo.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcialclinicapoo.R;

public class MainMedicoActivity extends AppCompatActivity {

    private Button buttonRegistroPaciente, buttonListaPacientes,
            buttonAsignarConsulta, buttonHistorialPaciente, buttonConsultasMedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_medico);

        buttonRegistroPaciente = findViewById(R.id.buttonRegistroPaciente);
        buttonListaPacientes = findViewById(R.id.buttonListaPacientes);
        buttonAsignarConsulta = findViewById(R.id.buttonAsignarConsulta);
        buttonHistorialPaciente = findViewById(R.id.buttonHistorialPaciente);
        buttonConsultasMedico = findViewById(R.id.buttonConsultasMedico);

        buttonRegistroPaciente.setOnClickListener(v -> startActivity(new Intent(this, RegistroPacienteActivity.class)));
        buttonListaPacientes.setOnClickListener(v -> startActivity(new Intent(this, ListaPacientesActivity.class)));
        buttonAsignarConsulta.setOnClickListener(v -> startActivity(new Intent(this, AsignarConsultaActivity.class)));
        buttonHistorialPaciente.setOnClickListener(v -> startActivity(new Intent(this, HistorialPacienteActivity.class)));
        buttonConsultasMedico.setOnClickListener(v -> startActivity(new Intent(this, ConsultasMedicoActivity.class)));
    }
}
