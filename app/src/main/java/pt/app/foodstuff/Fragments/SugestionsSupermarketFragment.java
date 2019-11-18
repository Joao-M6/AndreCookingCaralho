package pt.app.foodstuff.Fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import pt.app.foodstuff.R;

public class SugestionsSupermarketFragment extends Fragment implements
        OnMapReadyCallback,
        LocationListener,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener{

    SupportMapFragment mapFragment;
    GoogleMap mMap;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sugestions_supermarket, container, false);

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.sugestions_supermarket_mapView);
        if (mapFragment == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.sugestions_supermarket_mapView, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);

        checkBox1 = (CheckBox) view.findViewById(R.id.supermarket_checkbox1);
        checkBox2 = (CheckBox) view.findViewById(R.id.supermarket_checkbox2);
        checkBox3 = (CheckBox) view.findViewById(R.id.supermarket_checkbox3);
        checkBox4 = (CheckBox) view.findViewById(R.id.supermarket_checkbox4);
        checkBox5 = (CheckBox) view.findViewById(R.id.supermarket_checkbox5);
        checkBox6 = (CheckBox) view.findViewById(R.id.supermarket_checkbox6);

        final View.OnClickListener hListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (checkBox1.isChecked()) {
                    Toast.makeText(getActivity(), "Marca no mapa so o supermercado 1", Toast.LENGTH_LONG).show();
                }
                if (checkBox2.isChecked()) {
                    Toast.makeText(getActivity(), "Marca no mapa so o supermercado 2", Toast.LENGTH_LONG).show();
                }
                if (checkBox3.isChecked()) {
                    Toast.makeText(getActivity(), "Marca no mapa so o supermercado 3", Toast.LENGTH_LONG).show();
                }
                if (checkBox4.isChecked()) {
                    Toast.makeText(getActivity(), "Marca no mapa so o supermercado 4", Toast.LENGTH_LONG).show();
                }
                if (checkBox5.isChecked()) {
                    Toast.makeText(getActivity(), "Marca no mapa so o supermercado 5", Toast.LENGTH_LONG).show();
                }
                if (checkBox6.isChecked()) {
                    Toast.makeText(getActivity(), "Marca no mapa so o supermercado 6", Toast.LENGTH_LONG).show();
                }
            }
        };

        view.findViewById(R.id.supermarket_checkbox1).setOnClickListener(hListener);
        view.findViewById(R.id.supermarket_checkbox2).setOnClickListener(hListener);
        view.findViewById(R.id.supermarket_checkbox3).setOnClickListener(hListener);
        view.findViewById(R.id.supermarket_checkbox4).setOnClickListener(hListener);
        view.findViewById(R.id.supermarket_checkbox5).setOnClickListener(hListener);
        view.findViewById(R.id.supermarket_checkbox6).setOnClickListener(hListener);

        return view;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this.getView().getContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }

    }
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this.getView().getContext())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API).build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this.getView().getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }
        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

}