package com.example.gato.actividades;

import static com.example.gato.R.id.txtRcpCorreo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gato.R;

public class RcpContraCorreoActivity extends AppCompatActivity {

    private EditText txtRcpCorreo, txtRcpCodigoCorreo;
    private Button btnValidarCorreo, btnContinuarCorreo, btnCancelarCorreo;
    private TextView txtTitulo, txtCorreoElectronico, txtCodeCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcp_contra_correo);

        // Inicializamos los componentes de la vista
        txtTitulo = findViewById(R.id.txtTitulo);
        txtCorreoElectronico = findViewById(R.id.txtCorreoElectronico);
        txtRcpCorreo = findViewById(R.id.txtRcpCorreo);
        btnValidarCorreo = findViewById(R.id.btnValidarCorreo);
        txtCodeCorreo = findViewById(R.id.txtCodeCorreo);
        txtRcpCodigoCorreo = findViewById(R.id.txtRcpCodigoCorreo);
        btnContinuarCorreo = findViewById(R.id.btnContinuarCorreo);
        btnCancelarCorreo = findViewById(R.id.btnCancelarCorreo);

        // Acción del botón Validar Correo
        btnValidarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = txtRcpCorreo.getText().toString().trim();
                if (TextUtils.isEmpty(correo)) {
                    Toast.makeText(RcpContraCorreoActivity.this, "Por favor, ingrese su correo", Toast.LENGTH_SHORT).show();
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                    Toast.makeText(RcpContraCorreoActivity.this, "Ingrese un correo electrónico válido", Toast.LENGTH_SHORT).show();
                } else {
                    // Lógica para enviar código de verificación al correo
                    // Esto puede conectarse a un servicio API para enviar el correo
                    Toast.makeText(RcpContraCorreoActivity.this, "Código de verificación enviado al correo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Acción del botón Continuar
        btnContinuarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigo = txtRcpCodigoCorreo.getText().toString().trim();

                if (TextUtils.isEmpty(codigo)) {
                    Toast.makeText(RcpContraCorreoActivity.this, "Por favor, ingrese el código de verificación", Toast.LENGTH_SHORT).show();
                } else {
                    // Lógica para verificar el código ingresado
                    // Aquí puedes validar el código con el servidor
                    Toast.makeText(RcpContraCorreoActivity.this, "Código verificado correctamente", Toast.LENGTH_SHORT).show();

                    // Lógica para continuar con el proceso (ej: redirigir a restablecimiento de contraseña)
                }
            }
        });

        // Acción del botón Cancelar
        btnCancelarCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para cancelar el proceso y volver a la pantalla anterior
                finish(); // Cierra la actividad actual y regresa a la anterior
            }
        });
    }
}