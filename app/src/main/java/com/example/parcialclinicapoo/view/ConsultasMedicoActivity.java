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

public class ConsultasMedicoActivity extends AppCompatActivity {

    private Spinner spinnerMedicos;
    private ListView listViewConsultas;
    private ClinicaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas_medico);

        spinnerMedicos = findViewById(R.id.spinnerSeleccionMedico);
        listViewConsultas = findViewById(R.id.listViewConsultas);

        viewModel = ClinicaViewModel.getInstance();

        ArrayAdapter<String> medicoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        for (var m : viewModel.getMedicos()) {
            medicoAdapter.add(m.getIdentificacion());
        }
        spinnerMedicos.setAdapter(medicoAdapter);

        spinnerMedicos.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long l) {
                String idMedico = spinnerMedicos.getSelectedItem().toString();
                List<Consulta> consultas = viewModel.consultasMedico(idMedico);
                List<String> datos = new ArrayList<>();
                for (Consulta c : consultas) {
                    datos.add("Paciente: " + c.getPaciente().getNombre() + "\n" +
                            "Síntomas: " + c.getSintomas() + "\n" +
                            "Diagnóstico: " + c.getDiagnostico() + "\n" +
                            "Tratamiento: " + c.getTratamiento());
                }
                listViewConsultas.setAdapter(new ArrayAdapter<>(ConsultasMedicoActivity.this, android.R.layout.simple_list_item_1, datos));
            }

            @Override
            public void onNothingSelected(android.widget.AdapterView<?> adapterView) {}
        });
    }
}

