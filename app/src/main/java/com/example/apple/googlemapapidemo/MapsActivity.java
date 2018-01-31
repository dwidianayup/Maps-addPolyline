package com.example.apple.googlemapapidemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng alunalun = new LatLng(-6.870703, 109.036922);
        mMap.addMarker(new MarkerOptions().position(alunalun).title("Alun alun brebes"));
        LatLng Rsdedijaya = new LatLng(-6.871795, 109.043891);
        mMap.addMarker(new MarkerOptions().position(Rsdedijaya).title("RS Dedy Jaya"));
        LatLng kantorPos = new LatLng(-6.869850, 109.037357);
        mMap.addMarker(new MarkerOptions().position(kantorPos).title("Kantor Pos"));
        LatLng aquarius = new LatLng(-6.871319, 109.041485);
        mMap.addMarker(new MarkerOptions().position(aquarius).title("Lembaga Pendidikan Aquarius"));
        LatLng sma2 = new LatLng(-6.872669, 109.048330);
        mMap.addMarker(new MarkerOptions().position(sma2).title("SMA Negeri 2 Brebes"));

        LatLng tkn = new LatLng(-6.872669, 109.048330);

        mMap.addPolyline(new PolylineOptions().add(
                    alunalun, kantorPos, aquarius, Rsdedijaya, tkn
                )
                .width(10)
                .color(Color.RED)

        );



        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(alunalun, 18));
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
    }
}
