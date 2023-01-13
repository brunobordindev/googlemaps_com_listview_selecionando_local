package com.example.googlemapscomlistviewselecionandolocalmap;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapscomlistviewselecionandolocalmap.databinding.ActivityGoogleMapsBinding;

public class GoogleMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityGoogleMapsBinding binding;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityGoogleMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        i = getIntent();
        String titulo = i.getExtras().getString("titulo");
        double latitude = i.getExtras().getDouble("latitude");
        double longitude = i.getExtras().getDouble("longitude");

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng nomeQualquer = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(nomeQualquer).title(titulo));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nomeQualquer));
    }
}