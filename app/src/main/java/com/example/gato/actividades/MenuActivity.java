package com.example.gato.actividades;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.gato.R;
import com.example.gato.clases.Menu;
import com.example.gato.fragmentos.AnuncioFragment;
import com.example.gato.fragmentos.ConfiguracionFragment;
import com.example.gato.fragmentos.GatoFragment;
import com.example.gato.fragmentos.HomeFragment;
import com.example.gato.fragmentos.MasFragment;

public class MenuActivity extends AppCompatActivity implements Menu {
    Fragment[] fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fragments = new Fragment[5];
        fragments[0] = new AnuncioFragment();
        fragments[1] = new GatoFragment();
        fragments[2] = new MasFragment();
        fragments[3] = new HomeFragment();
        fragments[4] = new ConfiguracionFragment();

        int id = getIntent().getIntExtra("id",-1);
        onClickMenu(id);
    }
    @Override
    public void onClickMenu(int id) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.menRelArea, fragments[id]);
        ft.commit();
    }
}