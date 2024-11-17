package com.example.gato.actividades;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gato.R;

public class EditarPerfilActivity extends AppCompatActivity {

    // Declaración de variables para los elementos de la vista
    private EditText lblEditNombres, lblEditApellidos, lblEditDocumento, lblEditTelefono, lblEditCorreo, lblEditContrasena, lblEditConfirmarContrasena;
    private Spinner cmbDistrito;
    private Button btnCancelar, btnEditar;
    private String distritoSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        // Inicializa los elementos de la vista
        lblEditNombres = findViewById(R.id.lblEditNombres);
        lblEditApellidos = findViewById(R.id.lblEditApellidos);
        lblEditDocumento = findViewById(R.id.lblEditDocumento);
        lblEditTelefono = findViewById(R.id.lblEditTelefono);
        lblEditCorreo = findViewById(R.id.lblEditCorreo);
        lblEditContrasena = findViewById(R.id.lblEditContrasena);
        lblEditConfirmarContrasena = findViewById(R.id.lblEditConfirmarContrasena);
        cmbDistrito = findViewById(R.id.cmbDistrito);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnEditar = findViewById(R.id.btnEditar);

        // Configura el Spinner de distrito
        configurarSpinnerDistrito();

        // Carga los datos del perfil almacenados en SharedPreferences
        cargarDatosPerfil();

        // Acción para el botón Cancelar
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Acción para el botón Editar
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    guardarDatosPerfil();
                    finish(); // Cerrar la actividad después de guardar
                }
            }
        });
    }

    private void guardarDatosPerfil() {
        SharedPreferences preferences = getSharedPreferences("configuracion", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Guardar los valores de los campos de texto y el spinner
        editor.putString("nombres", lblEditNombres.getText().toString());
        editor.putString("apellidos", lblEditApellidos.getText().toString());
        editor.putString("documento", lblEditDocumento.getText().toString());
        editor.putString("telefono", lblEditTelefono.getText().toString());
        editor.putString("correo", lblEditCorreo.getText().toString());
        editor.putString("contrasena", lblEditContrasena.getText().toString());
        editor.putString("distrito", distritoSeleccionado); // Guardar distrito seleccionado

        // Aplicar los cambios
        editor.apply();

        Toast.makeText(EditarPerfilActivity.this, "Perfil actualizado", Toast.LENGTH_SHORT).show();
    }


    private void cargarDatosPerfil() {
        SharedPreferences preferences = getSharedPreferences("configuracion", MODE_PRIVATE);

        // Cargar los valores de los campos de texto
        lblEditNombres.setText(preferences.getString("nombres", ""));
        lblEditApellidos.setText(preferences.getString("apellidos", ""));
        lblEditDocumento.setText(preferences.getString("documento", ""));
        lblEditTelefono.setText(preferences.getString("telefono", ""));
        lblEditCorreo.setText(preferences.getString("correo", ""));
        lblEditContrasena.setText(preferences.getString("contrasena", ""));
        lblEditConfirmarContrasena.setText(preferences.getString("contrasena", "")); // Cargar también en confirmar contraseña

        // Cargar el distrito seleccionado en el spinner
        String distrito = preferences.getString("distrito", "");
        if (!distrito.isEmpty()) {
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) cmbDistrito.getAdapter();
            int position = adapter.getPosition(distrito);
            cmbDistrito.setSelection(position);
        }
    }



    private void configurarSpinnerDistrito() {
        String[] distritos = {"San Juan de Lurigancho", "San Isidro", "Miraflores", "Breña", "Chorrillos"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, distritos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cmbDistrito.setAdapter(adapter);
    }


    // Método para validar los campos
    private boolean validarCampos() {
        if (lblEditNombres.getText().toString().trim().isEmpty()) {
            lblEditNombres.setError("Ingrese sus nombres");
            return false;
        }
        if (lblEditApellidos.getText().toString().trim().isEmpty()) {
            lblEditApellidos.setError("Ingrese sus apellidos");
            return false;
        }
        if (lblEditDocumento.getText().toString().trim().isEmpty()) {
            lblEditDocumento.setError("Ingrese su documento");
            return false;
        }
        if (lblEditTelefono.getText().toString().trim().isEmpty()) {
            lblEditTelefono.setError("Ingrese su teléfono");
            return false;
        }
        if (lblEditCorreo.getText().toString().trim().isEmpty()) {
            lblEditCorreo.setError("Ingrese su correo");
            return false;
        }
        if (lblEditContrasena.getText().toString().trim().isEmpty()) {
            lblEditContrasena.setError("Ingrese su contraseña");
            return false;
        }
        if (!lblEditContrasena.getText().toString().equals(lblEditConfirmarContrasena.getText().toString())) {
            lblEditConfirmarContrasena.setError("Las contraseñas no coinciden");
            return false;
        }
        return true;
    }
}