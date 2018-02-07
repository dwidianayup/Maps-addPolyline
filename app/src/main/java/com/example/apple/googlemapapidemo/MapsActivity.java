package com.example.apple.googlemapapidemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng samsat = new LatLng(-7.009342, 110.470475);
        mMap.addMarker(new MarkerOptions().position(samsat).title("Samsat Semarang"));
//        LatLng Rsdedijaya = new LatLng(-6.871795, 109.043891);
//        mMap.addMarker(new MarkerOptions().position(Rsdedijaya).title("RS Dedy Jaya"));
//        LatLng kantorPos = new LatLng(-6.869850, 109.037357);
//        mMap.addMarker(new MarkerOptions().position(kantorPos).title("Kantor Pos"));
//        LatLng aquarius = new LatLng(-6.871319, 109.041485);
//        mMap.addMarker(new MarkerOptions().position(aquarius).title("Lembaga Pendidikan Aquarius"));
//        LatLng sma2 = new LatLng(-6.872669, 109.048330);
//        mMap.addMarker(new MarkerOptions().position(sma2).title("SMA Negeri 2 Brebes"));

//        LatLng tkn = new LatLng(-6.872669, 109.048330);

//        mMap.addPolyline(new PolylineOptions().add(
//                    alunalun, kantorPos, aquarius, Rsdedijaya, tkn
//                )
//                .width(10)
//                .color(Color.RED)
//
//        );


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(samsat, 16));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
//        mMap.setMyLocationEnabled(true);
    }

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
}
