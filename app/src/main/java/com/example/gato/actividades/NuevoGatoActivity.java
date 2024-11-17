package com.example.gato.actividades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gato.R;


public class NuevoGatoActivity extends AppCompatActivity {

    private EditText lblNombre, lblRaza, lblEdad;
    private Spinner cmbSexo, cmbTamano;
    private Button btnCancelar, btnAgregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nuevo_gato);

        lblNombre = findViewById(R.id.lblNombre);
        lblRaza = findViewById(R.id.lblRaza);
        lblEdad = findViewById(R.id.lblEdad);
        cmbSexo = findViewById(R.id.cmbSexo);
        cmbTamano = findViewById(R.id.cmbTamano);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnAgregar = findViewById(R.id.btnAgregar);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarCampos()) {
                    Toast.makeText(NuevoGatoActivity.this, "Gato agregado", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    private boolean validarCampos() {
        if (lblNombre.getText().toString().trim().isEmpty()) {
            lblNombre.setError("Ingrese el nombre");
            return false;
        }
        if (lblRaza.getText().toString().trim().isEmpty()) {
            lblRaza.setError("Ingrese la raza");
            return false;
        }
        if (lblEdad.getText().toString().trim().isEmpty()) {
            lblEdad.setError("Ingrese la edad");
            return false;
        }
        return true;
    }
}