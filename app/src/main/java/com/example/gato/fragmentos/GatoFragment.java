package com.example.gato.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.example.gato.R;
import com.example.gato.actividades.NuevoGatoActivity;
import com.example.gato.actividades.VerGatoActivity;
import com.example.gato.actividades.EditarGatoActivity;



/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GatoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GatoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ImageButton imgBtnNuevoGato;
    private ImageButton imgBtnVerGato;
    private ImageButton imgBtnEditarGato;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GatoFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static GatoFragment newInstance(String param1, String param2) {
        GatoFragment fragment = new GatoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        View view = inflater.inflate(R.layout.fragment_gato, container, false);

        imgBtnNuevoGato = view.findViewById(R.id.imgBtnNuevoGato);
        imgBtnVerGato = view.findViewById(R.id.imgBtnVerGato);
        imgBtnEditarGato = view.findViewById(R.id.imgBtnEditarGato);

        // Configuramos el click listener para abrir la actividad NuevoGatoActivity
        imgBtnNuevoGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad NuevoGatoActivity
                Intent intent = new Intent(getActivity(), NuevoGatoActivity.class);
                startActivity(intent);  // Inicia la actividad
            }
        });

        // Configuramos el click listener para abrir la actividad VerGatoActivity
        imgBtnVerGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad VerGatoActivity
                Intent intent = new Intent(getActivity(), VerGatoActivity.class);
                startActivity(intent);  // Inicia la actividad
            }
        });

        // Configuramos el click listener para abrir la actividad EditarGatoActivity
        imgBtnEditarGato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Iniciar la actividad EditarGatoActivity
                Intent intent = new Intent(getActivity(), EditarGatoActivity.class);
                startActivity(intent);  // Inicia la actividad
            }
        });

        // Retornar la vista inflada
        return view;
    }

}