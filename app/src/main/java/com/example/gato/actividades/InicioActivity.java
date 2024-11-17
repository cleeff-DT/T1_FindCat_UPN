package com.example.gato.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gato.R;
import com.example.gato.sqlite.Gatos;

public class InicioActivity extends AppCompatActivity {

    ProgressBar barCarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        barCarga = findViewById(R.id.iniBarCarga);

        Thread tCarga = new Thread(new Runnable() {
            @Override
            public void run() {
                //validar y pintar la barra de progreso
                for (int i = 0; i < barCarga.getMax(); i++) {
                    barCarga.setProgress(i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                Gatos bv = new Gatos(getApplicationContext());
                if(bv.recordoSesion()){
                    //llamr a la actividad BIENVENIDA
                    Intent bienvenida = new Intent(getApplicationContext(), BienvenidaActivity.class);
                    bienvenida.putExtra("nombre","Tokiro");
                    startActivity(bienvenida);
                }
                else {
                    //Llamar a la otra SESION
                    Intent sesion = new Intent(getApplicationContext(), SesionActivity.class);
                    startActivity(sesion);
                }
                finish();
            }
        });
        tCarga.start();

    }
}