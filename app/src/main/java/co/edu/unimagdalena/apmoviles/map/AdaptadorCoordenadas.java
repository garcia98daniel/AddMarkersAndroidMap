package co.edu.unimagdalena.apmoviles.map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptadorCoordenadas extends ArrayAdapter<Coordenadas> {


    private Context context;
    private ArrayList<Coordenadas> coordenadas;
    private LayoutInflater inflater;

    public AdaptadorCoordenadas(@NonNull Context context, ArrayList<Coordenadas> coordenadas) {
        super(context,0,coordenadas);
        this.context = context;
        this.coordenadas = coordenadas;
        inflater= LayoutInflater.from(context);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Nullable
    @Override
    public Coordenadas getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            convertView = inflater.inflate(R.layout.coordenadas_item,null);

        }
        Coordenadas coor = getItem(position);
        TextView coor1 = convertView.findViewById(R.id.coor1);
        TextView coor2 = convertView.findViewById(R.id.coor2);
        coor1.setText("coordenada 1: " + coor.getCoor1());
        coor2.setText("coordenada 2: " + coor.getCoor2());
        return convertView;
    }
}
