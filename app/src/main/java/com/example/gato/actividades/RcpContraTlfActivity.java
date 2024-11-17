package com.example.gato.actividades;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gato.R;

public class RcpContraTlfActivity extends AppCompatActivity {

    private EditText txtRcpTelefono, txtRcpCodigoTlf;
    private Button btnValidarTlf, btnContinuarTlf, btnCancelarTlf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcp_contra_tlf);

        // Inicializar los componentes de la vista
        txtRcpTelefono = findViewById(R.id.txtRcpTelefono);
        txtRcpCodigoTlf = findViewById(R.id.txtRcpCodigoTlf);
        btnValidarTlf = findViewById(R.id.btnValidarTlf);
        btnContinuarTlf = findViewById(R.id.btnContinuarTlf);
        btnCancelarTlf = findViewById(R.id.btnCancelarTlf);

        // Acción del botón Validar número telefónico
        btnValidarTlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telefono = txtRcpTelefono.getText().toString().trim();

                if (TextUtils.isEmpty(telefono)) {
                    Toast.makeText(RcpContraTlfActivity.this, "Por favor, ingrese su número telefónico", Toast.LENGTH_SHORT).show();
                } else if (telefono.length() < 9 || telefono.length() > 12) {
                    Toast.makeText(RcpContraTlfActivity.this, "Ingrese un número telefónico válido", Toast.LENGTH_SHORT).show();
                } else {
                    // Lógica para enviar el código de verificación vía SMS
                    // Aquí puedes integrar una API de SMS (ejemplo: Twilio)
                    Toast.makeText(RcpContraTlfActivity.this, "Código de verificación enviado al número", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Acción del botón Continuar
        btnContinuarTlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = txtRcpCodigoTlf.getText().toString().trim();

                if (TextUtils.isEmpty(codigo)) {
                    Toast.makeText(RcpContraTlfActivity.this, "Por favor, ingrese el código de verificación", Toast.LENGTH_SHORT).show();
                } else {
                    // Lógica para verificar el código ingresado
                    // Aquí puedes agregar la validación del código con un backend o API
                    Toast.makeText(RcpContraTlfActivity.this, "Código verificado correctamente", Toast.LENGTH_SHORT).show();

                    // Lógica para continuar (ej: redirigir a restablecer contraseña)
                }
            }
        });

        // Acción del botón Cancelar
        btnCancelarTlf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra la actividad actual y regresa a la anterior
                finish();
            }
        });
    }
}