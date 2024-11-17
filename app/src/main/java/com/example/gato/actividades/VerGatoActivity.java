package com.example.gato.actividades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gato.R;

public class VerGatoActivity extends AppCompatActivity {

    private EditText lblNombre, lblRaza, lblEdad;
    private Spinner cmbSexo, cmbTamano;
    private Button btnRegresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ver_gato);

        lblNombre = findViewById(R.id.lblNombre);
        lblRaza = findViewById(R.id.lblRaza);
        lblEdad = findViewById(R.id.lblEdad);
        cmbSexo = findViewById(R.id.cmbSexo);
        cmbTamano = findViewById(R.id.cmbTamano);
        btnRegresar= findViewById(R.id.btnRegresar);

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}