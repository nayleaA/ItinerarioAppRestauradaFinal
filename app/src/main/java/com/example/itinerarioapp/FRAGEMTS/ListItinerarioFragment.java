package com.example.itinerarioapp.FRAGEMTS;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itinerarioapp.DB.dbHelper;
import com.example.itinerarioapp.R;

public class ListItinerarioFragment extends Fragment {

    RecyclerView recyclerView;
    private SQLiteDatabase database;

    public ListItinerarioFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_list_itinerario, container, false);
       // View view = inflater.inflate(R.layout.fragment_list_itinerario, container, false);
        // Inicializar RecyclerView y dataList
       // recyclerView = view.findViewById(R.id.recycler_view);

        // Abrir la base de datos
       // dbHelper dbHelper = new dbHelper(getActivity());
       // database = dbHelper.getReadableDatabase();

        // Cargar datos desde la base de datos SQLite
        // loadDataFromDatabase();
        return recyclerView;
    }

    /* private void loadDataFromDatabase() {
        Cursor cursor = database.rawQuery("SELECT * FROM tabla_datos", null);

        if (cursor.moveToFirst()) {
            do {
                // Obtener datos de cada fila y crear un objeto MyDataModel
                int id = cursor.getInt(0);
                String area = cursor.getString(1);
                String fecha = cursor.getString(2);
                String horaInicio = cursor.getString(3);
                String horaFin = cursor.getString(4);
                String telefono = cursor.getString(5);
                String nombre = cursor.getString(6);
                String actividad = cursor.getString(7);

                // Crear un objeto  con los datos obtenidos

                // Añadir el objeto a la lista de datos

            } while (cursor.moveToNext());
        }
        // Cerrar el cursor
        cursor.close();
    }*/
}