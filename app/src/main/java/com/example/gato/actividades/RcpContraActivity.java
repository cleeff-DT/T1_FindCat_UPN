package com.example.gato.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gato.R;

public class RcpContraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcp_contra);

        Button btnCorreo = findViewById(R.id.btnCorreo);
        Button btnTelefono = findViewById(R.id.btnTelefono);
        Button btnCancelar = findViewById(R.id.btnCancelar);

        btnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia la actividad RcpContraCorreoActivity
                Intent intent = new Intent(RcpContraActivity.this, RcpContraCorreoActivity.class);
                startActivity(intent);
            }
        });

        btnTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inicia la actividad RcpContraTlfActivity
                Intent intent = new Intent(RcpContraActivity.this, RcpContraTlfActivity.class);
                startActivity(intent);
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RcpContraActivity.this, SesionActivity.class);
                startActivity(intent);
            }
        });
    }
}