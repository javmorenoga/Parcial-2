package com.example.parcialclinicapoo.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcialclinicapoo.R;
import com.example.parcialclinicapoo.model.Consulta;
import com.example.parcialclinicapoo.viewmodel.ClinicaViewModel;

import java.util.ArrayList;
import java.util.List;

public class HistorialPacienteActivity extends AppCompatActivity {

    private Spinner spinnerPacientes;
    private ListView listViewHistorial;
    private ClinicaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial_paciente);

        spinnerPacientes = findViewById(R.id.spinnerSeleccionPaciente);
        listViewHistorial = findViewById(R.id.listViewHistorial);

        viewModel = ClinicaViewModel.getInstance();

        // Llenar Spinner con IDs de pacientes
        ArrayAdapter<String> pacienteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        for (var p : viewModel.getPacientes()) {
            pacienteAdapter.add(p.getIdentificacion());
        }
        spinnerPacientes.setAdapter(pacienteAdapter);

        spinnerPacientes.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long l) {
                String idPaciente = spinnerPacientes.getSelectedItem().toString();
                List<Consulta> historial = viewModel.historialPaciente(idPaciente);
                List<String> datos = new ArrayList<>();
                for (Consulta c : historial) {
                    datos.add("Dr. " + c.getMedico().getNombre() + "\n" +
                            "Síntomas: " + c.getSintomas() + "\n" +
                            "Diagnóstico: " + c.getDiagnostico() + "\n" +
                            "Tratamiento: " + c.getTratamiento());
                }
                listViewHistorial.setAdapter(new ArrayAdapter<>(HistorialPacienteActivity.this, android.R.layout.simple_list_item_1, datos));
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> adapterView) {}
        });
    }
}