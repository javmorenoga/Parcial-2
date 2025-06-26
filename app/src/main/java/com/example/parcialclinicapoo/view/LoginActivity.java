package com.example.parcialclinicapoo.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.parcialclinicapoo.R;
import com.example.parcialclinicapoo.model.Administrador;
import com.example.parcialclinicapoo.model.Medico;
import com.example.parcialclinicapoo.viewmodel.ClinicaViewModel;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextId, editTextPassword;
    private Button buttonLogin;
    private RadioGroup radioGroupRol;
    private RadioButton radioAdmin, radioMedico;
    private ClinicaViewModel viewModel = ClinicaViewModel.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextId = findViewById(R.id.editTextIdUsuario);
        editTextPassword = findViewById(R.id.editTextContrasena);
        buttonLogin = findViewById(R.id.buttonLogin);
        radioGroupRol = findViewById(R.id.radioGroupRol);
        radioAdmin = findViewById(R.id.radioAdmin);
        radioMedico = findViewById(R.id.radioMedico);

        // Cargar los datos guardados
        viewModel.cargarDatos(this);

        buttonLogin.setOnClickListener(v -> {
            String id = editTextId.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            if (id.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            int selectedId = radioGroupRol.getCheckedRadioButtonId();

            if (selectedId == -1) {
                Toast.makeText(this, "Por favor selecciona un rol", Toast.LENGTH_SHORT).show();
                return;
            }

            if (radioMedico.isChecked()) {
                Medico medico = viewModel.buscarMedico(id);
                if (medico != null && medico.getContrasena().equals(password)) {
                    Toast.makeText(this, "Login exitoso como Médico", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainMedicoActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "ID o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            } else if (radioAdmin.isChecked()) {
                Administrador admin = viewModel.buscarAdministrador(id);
                if (admin != null && admin.getContrasena().equals(password)) {
                    Toast.makeText(this, "Login exitoso como Administrativo", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, MainAdminActivity.class));
                    finish();
                } else {
                    Toast.makeText(this, "ID o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
