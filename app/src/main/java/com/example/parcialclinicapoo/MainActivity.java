package com.example.parcialclinicapoo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcialclinicapoo.R;
import com.example.parcialclinicapoo.view.AsignarConsultaActivity;
import com.example.parcialclinicapoo.view.ConsultasMedicoActivity;
import com.example.parcialclinicapoo.view.HistorialPacienteActivity;
import com.example.parcialclinicapoo.view.ListaPacientesActivity;
import com.example.parcialclinicapoo.view.RegistroMedicoActivity;
import com.example.parcialclinicapoo.view.RegistroPacienteActivity;
import com.example.parcialclinicapoo.viewmodel.ClinicaViewModel;

public class MainActivity extends AppCompatActivity {

    private Button buttonRegistroPaciente, buttonRegistroMedico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 🔁 Cargar datos persistentes al iniciar la app
        ClinicaViewModel.getInstance().cargarDatos(this);

        buttonRegistroPaciente = findViewById(R.id.buttonRegistroPaciente);
        buttonRegistroMedico = findViewById(R.id.buttonRegistroMedico);
        Button btnListaPacientes = findViewById(R.id.buttonListaPacientes);
        Button btnListaMedicos = findViewById(R.id.buttonListaMedicos);
        Button buttonAsignarConsulta = findViewById(R.id.buttonAsignarConsulta);
        Button btnHistorialPaciente = findViewById(R.id.buttonHistorialPaciente);
        Button btnConsultasMedico = findViewById(R.id.buttonConsultasMedico);

        buttonRegistroPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistroPacienteActivity.class));
            }
        });

        btnListaPacientes.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListaPacientesActivity.class);
            startActivity(intent);
        });

        buttonRegistroMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistroMedicoActivity.class));
            }
        });

        btnListaMedicos.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, com.example.parcialclinicapoo.view.ListaMedicosActivity.class);
            startActivity(intent);
        });
        buttonAsignarConsulta.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AsignarConsultaActivity.class));
        });
        btnHistorialPaciente.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, HistorialPacienteActivity.class));
        });

        btnConsultasMedico.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ConsultasMedicoActivity.class));
        });

    }
}
