package com.example.parcialclinicapoo.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.parcialclinicapoo.R;
import com.example.parcialclinicapoo.model.Paciente;
import com.example.parcialclinicapoo.viewmodel.ClinicaViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListaPacientesActivity extends Activity {

    private ClinicaViewModel viewModel = ClinicaViewModel.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacientes);

        //  Cargar datos antes de usarlos
        viewModel.cargarDatos(getApplicationContext());

        ListView listaPacientes = findViewById(R.id.listaPacientes);

        List<Paciente> pacientes = viewModel.getPacientes();
        List<String> nombres = new ArrayList<>();
        for (Paciente p : pacientes) {
            nombres.add(p.getNombre() + " - " + p.getIdentificacion());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                nombres
        );

        listaPacientes.setAdapter(adapter);
    }
}
