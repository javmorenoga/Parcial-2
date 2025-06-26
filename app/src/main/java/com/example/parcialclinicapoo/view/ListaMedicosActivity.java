package com.example.parcialclinicapoo.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.parcialclinicapoo.R;
import com.example.parcialclinicapoo.model.Medico;
import com.example.parcialclinicapoo.viewmodel.ClinicaViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListaMedicosActivity extends Activity {

    private ClinicaViewModel viewModel = ClinicaViewModel.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_medicos);

        ListView listaMedicos = findViewById(R.id.listaMedicos);

        List<Medico> medicos = viewModel.getMedicos();
        List<String> datosMedicos = new ArrayList<>();

        for (Medico m : medicos) {
            datosMedicos.add(
                    "Nombre: " + m.getNombre() +
                            " | ID: " + m.getIdentificacion() +
                            " | Especialidad: " + m.getEspecialidad() +
                            " | Contraseña: " + m.getContrasena()
            );
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                datosMedicos
        );

        listaMedicos.setAdapter(adapter);
    }
}