package com.example.parcialclinicapoo.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcialclinicapoo.R;
import com.example.parcialclinicapoo.viewmodel.ClinicaViewModel;

public class RegistroPacienteActivity extends AppCompatActivity {

    private EditText etNombre, etId;
    private Button btnRegistrar;
    private ClinicaViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_paciente);

        etNombre = findViewById(R.id.etNombrePaciente);
        etId = findViewById(R.id.etIdPaciente);
        btnRegistrar = findViewById(R.id.btnRegistrarPaciente);

        // ✅ Asignar correctamente el viewModel al campo de clase
        viewModel = ClinicaViewModel.getInstance();

        btnRegistrar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString();
            String id = etId.getText().toString();

            if (nombre.isEmpty() || id.isEmpty()) {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                viewModel.registrarPaciente(nombre, id);

                // ✅ Guardar datos tras registrar
                viewModel.guardarDatos(getApplicationContext());

                Toast.makeText(this, "Paciente registrado exitosamente", Toast.LENGTH_SHORT).show();
                etNombre.setText("");
                etId.setText("");
            }
        });
    }
}
