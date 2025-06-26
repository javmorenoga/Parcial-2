package com.example.parcialclinicapoo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcialclinicapoo.R;
import com.example.parcialclinicapoo.viewmodel.ClinicaViewModel;

public class RegistroMedicoActivity extends AppCompatActivity {

    private EditText nombreEditText, idEditText, especialidadEditText;
    private Button registrarButton;
    private ClinicaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_medico);

        // ✅ Usar el campo de clase correctamente
        viewModel = ClinicaViewModel.getInstance();

        nombreEditText = findViewById(R.id.editTextNombreMedico);
        idEditText = findViewById(R.id.editTextIdMedico);
        especialidadEditText = findViewById(R.id.editTextEspecialidad);
        registrarButton = findViewById(R.id.buttonRegistrarMedico);
        EditText contrasenaEditText = findViewById(R.id.editTextContrasenaMedico);

        registrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = nombreEditText.getText().toString();
                String id = idEditText.getText().toString();
                String especialidad = especialidadEditText.getText().toString();
                String contrasena = contrasenaEditText.getText().toString();

                if (!nombre.isEmpty() && !id.isEmpty() && !especialidad.isEmpty() && !contrasena.isEmpty()) {
                    viewModel.registrarMedico(nombre, id, especialidad, contrasena);

                    // ✅ Guardar los datos después del registro
                    viewModel.guardarDatos(getApplicationContext());

                    Toast.makeText(RegistroMedicoActivity.this, "Médico registrado exitosamente", Toast.LENGTH_SHORT).show();
                    nombreEditText.setText("");
                    idEditText.setText("");
                    especialidadEditText.setText("");
                    contrasenaEditText.setText("");
                } else {
                    Toast.makeText(RegistroMedicoActivity.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
