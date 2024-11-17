package com.example.gato.fragmentos;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.util.GeoPoint;
import com.example.gato.R;

public class HomeFragment extends Fragment {

    private MapView mapView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize OSMDroid configuration
        Configuration.getInstance().load(getContext(), PreferenceManager.getDefaultSharedPreferences(getContext()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mapView = view.findViewById(R.id.map);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);

        // Centrar el mapa en Lima
        GeoPoint lima = new GeoPoint(-12.0464, -77.0428); // Coordenadas de Lima
        mapView.getController().setZoom(12); // Ajusta el nivel de zoom
        mapView.getController().setCenter(lima);

        // Agregar marcadores de texto
        addMarker(-12.045, -77.034, "Rímac"); // Rimac
        addMarker(-12.177, -77.018, "Chorrillos"); // Chorrillos
        addMarker(-12.032, -77.019, "Santa Clara"); // Santa Clara
        addMarker(-12.002, -77.020, "San Martín de Porres"); // San Martín de Porres

        return view;
    }

    private void addMarker(double lat, double lon, String title) {
        Marker marker = new Marker(mapView);
        marker.setPosition(new GeoPoint(lat, lon));
        marker.setTextIcon(title); // Establece el texto de la etiqueta
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM); // Alineación del texto
        mapView.getOverlays().add(marker);
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume(); // Activar el mapa
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause(); // Pausar el mapa
    }
}
