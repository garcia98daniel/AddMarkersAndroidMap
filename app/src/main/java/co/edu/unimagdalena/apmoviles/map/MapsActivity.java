package co.edu.unimagdalena.apmoviles.map;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity  extends FragmentActivity implements OnMapReadyCallback , View.OnClickListener
{
    EditText coor1, coor2;
    Button agregar, ver;
    SupportMapFragment mapFragment;
    ArrayList<LatLng> arrayCoordenadas = new ArrayList<LatLng>();

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        agregar = findViewById(R.id.agregar);
        agregar.setOnClickListener(this);

        //ver = findViewById(R.id.ver);
       // ver.setOnClickListener(this);

        coor1 = findViewById(R.id.coor1);
        coor2 = findViewById(R.id.coor2);

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
       /* LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

        if(!arrayCoordenadas.isEmpty()){
            for (int i = 0; i < arrayCoordenadas.size(); i++) {
                mMap.addMarker(new MarkerOptions().position(arrayCoordenadas.get(i)).title(""));
            }
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.agregar:

                if( coor1.getText().toString().isEmpty() || coor2.getText().toString().isEmpty()  ){

                    Toast.makeText(MapsActivity.this, "coordenadas requeridas", Toast.LENGTH_SHORT).show();

                }else{
                    LatLng coordenadas = new LatLng(Double.parseDouble(coor1.getText().toString()), Double.parseDouble(coor2.getText().toString()));
                    arrayCoordenadas.add(coordenadas);
                    Toast.makeText(getApplicationContext(),"Coordenadas ("+coor1.getText().toString()+","+coor2.getText().toString()+") agregadas", Toast.LENGTH_LONG).show();
                    mapFragment.getMapAsync(this);
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(coordenadas));
                }
                break;
            default:
                break;

        }


    }
}