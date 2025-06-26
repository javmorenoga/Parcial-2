package com.example.parcialclinicapoo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcialclinicapoo.R;
import com.example.parcialclinicapoo.model.Medico;
import com.example.parcialclinicapoo.model.Paciente;
import com.example.parcialclinicapoo.viewmodel.ClinicaViewModel;

import java.util.List;

public class AsignarConsultaActivity extends AppCompatActivity {

    private Spinner spinnerPacientes, spinnerMedicos;
    private EditText editTextSintomas, editTextDiagnostico, editTextTratamiento;
    private Button buttonAsignar;

    private ClinicaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar_consulta);

        viewModel = ClinicaViewModel.getInstance();

        spinnerPacientes = findViewById(R.id.spinnerPacientes);
        spinnerMedicos = findViewById(R.id.spinnerMedicos);
        editTextSintomas = findViewById(R.id.editTextSintomas);
        editTextDiagnostico = findViewById(R.id.editTextDiagnostico);
        editTextTratamiento = findViewById(R.id.editTextTratamiento);
        buttonAsignar = findViewById(R.id.buttonAsignarConsulta);

        // Llenar los spinners
        List<Paciente> pacientes = viewModel.getPacientes();
        List<Medico> medicos = viewModel.getMedicos();

        ArrayAdapter<String> pacienteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        for (Paciente p : pacientes) {
            pacienteAdapter.add(p.getIdentificacion());
        }
        spinnerPacientes.setAdapter(pacienteAdapter);

        ArrayAdapter<String> medicoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        for (Medico m : medicos) {
            medicoAdapter.add(m.getIdentificacion());
        }
        spinnerMedicos.setAdapter(medicoAdapter);

        // Acción del botón
        buttonAsignar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idPaciente = spinnerPacientes.getSelectedItem().toString();
                String idMedico = spinnerMedicos.getSelectedItem().toString();
                String sintomas = editTextSintomas.getText().toString();
                String diagnostico = editTextDiagnostico.getText().toString();
                String tratamiento = editTextTratamiento.getText().toString();

                if (!sintomas.isEmpty() && !diagnostico.isEmpty() && !tratamiento.isEmpty()) {
                    viewModel.asignarConsulta(idPaciente, idMedico, sintomas, diagnostico, tratamiento);
                    viewModel.guardarDatos(getApplicationContext());
                    Toast.makeText(AsignarConsultaActivity.this, "Consulta asignada con éxito", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(AsignarConsultaActivity.this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}