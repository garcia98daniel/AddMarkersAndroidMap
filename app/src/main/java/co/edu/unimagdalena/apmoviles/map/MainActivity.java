package co.edu.unimagdalena.apmoviles.map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    EditText coor1, coor2;
    Button agregar, ver;
    Coordenadas coordenadas;

    ArrayList<Coordenadas> arrayCoordenadas = new ArrayList<Coordenadas>();
    ListView listado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listado = findViewById(R.id.listado);
        agregar = findViewById(R.id.agregar);
        ver = findViewById(R.id.ver);
        coor1 = findViewById(R.id.coor1);
        coor2 = findViewById(R.id.coor2);

        agregar.setOnClickListener(this);
        ver.setOnClickListener(this);

        listado = findViewById(R.id.listado);


    }



    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.agregar: //agregarEstudiante(e);
                if( TextUtils.isEmpty(coor1.getText().toString()) || TextUtils.isEmpty(coor2.getText().toString()) ){
                    Toast.makeText(this,"coordenadas requeridas", Toast.LENGTH_LONG).show();
                }
                else{
                    Coordenadas coordenadas = new Coordenadas(Integer.parseInt(coor1.getText().toString()), Integer.parseInt(coor2.getText().toString()));
                    arrayCoordenadas.add(coordenadas);
                    Toast.makeText(getApplicationContext(),"Coordenadas ("+coor1.getText().toString()+","+coor2.getText().toString()+") agregadas", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.ver:
                    Intent i = new Intent(this, MapsActivity.class);
                    /*i.putExtra("codigoItem", "");
                    i.putExtra("nombreItem", "");
                    i.putExtra("programaItem", "");*/
                    startActivity(i);
                break;
            default:
                break;
        }

    }
}