package com.example.gato.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.gato.R;
import com.example.gato.clases.Hash;
import com.example.gato.sqlite.Gatos;

public class SesionActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtCorreo, txtClave;
    Button btnIngresar, btnSalir, btnRegistrate;
    CheckBox chkRecordar;
    TextView lblOlvidoC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sesion);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtCorreo = findViewById(R.id.logTxtUsuario);
        txtClave = findViewById(R.id.logTxtContra);
        btnIngresar = findViewById(R.id.logBtnIngresar);
        btnRegistrate = findViewById(R.id.logBtnRegistrate);
        btnSalir = findViewById(R.id.logBtnSalir);
        chkRecordar = findViewById(R.id.logChxRecordar);
        lblOlvidoC = findViewById(R.id.logLblOlvidoC);

        btnIngresar.setOnClickListener((this));
        btnSalir.setOnClickListener(this);
        btnRegistrate.setOnClickListener(this);
        lblOlvidoC .setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.logBtnIngresar)
            iniciarSesion(txtCorreo.getText().toString(), txtClave.getText().toString());
        else if (view.getId() == R.id.logBtnSalir)
            salir();
        else if (view.getId() == R.id.logBtnRegistrate)
            registrar();
        else if (view.getId() == R.id.logLblOlvidoC)
            OlvidarContraseña();
    }

    private void OlvidarContraseña() {
        Intent rcpContra = new Intent(this, RcpContraActivity.class);
        startActivity(rcpContra);
        finish();
    }

    private void registrar() {
        Intent registro = new Intent(this, RegistroActivity.class);
        startActivity(registro);
        finish();
    }

    private void iniciarSesion(String txtCorreo, String txtClave) {

        Gatos bv = new Gatos(getApplicationContext());
        Hash hash = new Hash();
        txtClave = hash.StringToHash(txtClave, "SHA256").toLowerCase();

        //validar en una base de datos
        if (txtCorreo.equals("polar@upn.pe")&& txtClave.equals("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3")){
            Intent bienvenida = new Intent(this, BienvenidaActivity.class);
            //bienvenida.putExtra("nombre","Tokiro");
            if(chkRecordar.isChecked()){
                //aca se guarda correo y clave en sqlite
                bv.agregarUsuario(1,txtCorreo,txtClave);
            }
            startActivity(bienvenida);
            finish();
        }
        else{
            Toast.makeText(this,"ERROR: Credenciales incorrectas",Toast.LENGTH_LONG).show();
        }
    }
    private void salir() {
        System.exit(1);
    }

}