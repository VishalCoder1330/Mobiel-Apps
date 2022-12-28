package com.example.vishal_parekh_comp304_assign5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int LOCATION_REQUEST_CODE = 1234;
    private static final float DEFAULT_ZOOM = 10f;
    private boolean mLocationPermissionGranted = false;

    private int mapType;
    private List<Theaters> mapTheater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Cities mapCity;
        mapCity = (Cities) getIntent().getSerializableExtra("city");
        mapType = getIntent().getIntExtra("type", 1);
        System.out.println("ampTypes"+mapType);
        System.out.println("map"+mapCity.getNames());


        if (mapCity != null && mapCity.getTheaters() != null)
            mapTheater = mapCity.getTheaters();

        initMap();
        getLocationPermission();

    }

    public void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    private void getLocationPermission() {

        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionGranted = true;

            } else {
                ActivityCompat.requestPermissions(this, permissions, LOCATION_REQUEST_CODE);
            }
        } else {
            ActivityCompat.requestPermissions(this, permissions, LOCATION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mLocationPermissionGranted = false;

        if (requestCode == LOCATION_REQUEST_CODE) {
            if (grantResults.length > 0) {
                for (int grantResult : grantResults) {
                    if (grantResult == PackageManager.PERMISSION_GRANTED) {
                        mLocationPermissionGranted = false;
                        return;
                    }
                }
                mLocationPermissionGranted = true;
                //initialize our map
                initMap();
            }
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

            if (mapType == 1) {
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            } else if (mapType == 2) {
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            } else if (mapType == 3) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
            setTheaterMarkers();

    }

    private void setTheaterMarkers() {
        if (mapTheater != null && mapTheater.size() > 0) {
            for (int i = 0; i < mapTheater.size(); i++) {
                LatLng latLng = new LatLng(mapTheater.get(i).getLat(), mapTheater.get(i).getLon());

                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(mapTheater.get(i).getTheaterName())
                        .snippet("Address: " + mapTheater.get(i).getAddress() + "\n" + "Mobile no: " + mapTheater.get(i).getContact()
                                + "\n" + "Website: " + mapTheater.get(i).getWebsiteURL())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));

                //Set Custom InfoWindow Adapter
                CustomInfoWindowAdater adapter = new CustomInfoWindowAdater(MapsActivity.this);
                mMap.setInfoWindowAdapter(adapter);

                /*mMap.addMarker(options).showInfoWindow();*/
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f));
            }
        }
    }
    public class CustomInfoWindowAdater implements GoogleMap.InfoWindowAdapter {

        private Activity context;

        public CustomInfoWindowAdater(Activity context) {
            this.context = context;
        }

        @Nullable
        @Override
        public View getInfoContents(@NonNull Marker marker) {
            View view = context.getLayoutInflater().inflate(R.layout.popup, null);

            TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            TextView tvSubTitle = (TextView) view.findViewById(R.id.tvSubtitle);

            tvTitle.setText(marker.getTitle());
            tvSubTitle.setText(marker.getSnippet());

            return view;
        }

        @Nullable
        @Override
        public View getInfoWindow(@NonNull Marker marker) {
            return null;
        }
    }
}
