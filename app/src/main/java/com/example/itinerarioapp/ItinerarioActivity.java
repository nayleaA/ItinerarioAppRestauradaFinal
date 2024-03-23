package com.example.itinerarioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.itinerarioapp.CALENDARIO.DatePickerFragment;
import com.example.itinerarioapp.DB.dbHelper;
import com.example.itinerarioapp.FRAGEMTS.ListItinerarioFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ItinerarioActivity extends AppCompatActivity {

    //variables para el boton, y el icono buscar
    FloatingActionButton fabAddReservation;
    ImageButton busqueda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerario);

        //creando la BD
        dbHelper dbhelper = new dbHelper(ItinerarioActivity.this);
        SQLiteDatabase db = dbhelper.getWritableDatabase(); //escribir
        SQLiteDatabase dbr = dbhelper.getReadableDatabase(); //leer

        // Cargar el fragmento en el contenedor
        loadFragment(new ListItinerarioFragment());


        //cargar la fecha de busqueda
        busqueda= findViewById(R.id.buscar);
        busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ItinerarioActivity.this, "Diste click en busqueda", Toast.LENGTH_SHORT).show();
                abrircalendario();
            }
        });

        //agregar una nueva tarjeta
        fabAddReservation = findViewById(R.id.fab_add_reservation);
        // Agregar evento al botón flotante
        fabAddReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aquí es donde manejarás el evento del botón flotante
                Toast.makeText(ItinerarioActivity.this, "¡Has dado clic en el botón flotante!", Toast.LENGTH_SHORT).show();

                if (db != null) //si la bd se creo  manda a insertar
                {
                    dbhelper.inserta(db);
                    Toast.makeText(ItinerarioActivity.this, "Inserté datos", Toast.LENGTH_LONG);
                }
                else { //si no error
                    Toast.makeText(ItinerarioActivity.this, "Error al insertar Base de datos", Toast.LENGTH_LONG).show();
                }

                 dbhelper.consultar(dbr);

                Toast.makeText(ItinerarioActivity.this, "datos inserto"+dbr, Toast.LENGTH_SHORT).show();

            }
        });
    }
    // Método para cargar un fragmento en el contenedor
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    //metodo que rescata la fecha del calendario
    public void abrircalendario() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = year + "/" + (month + 1) + "/" + day;
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}