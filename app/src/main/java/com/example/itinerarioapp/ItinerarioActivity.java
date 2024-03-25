package com.example.itinerarioapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.itinerarioapp.Adaptadores.AdaptadorLista;
import com.example.itinerarioapp.CALENDARIO.DatePickerFragment;
import com.example.itinerarioapp.DB.dbHelper;
import com.example.itinerarioapp.FRAGEMTS.ListItinerarioFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* Clase principal dela carga de elementos de la aplicacion,
* carga la toolbar, el fragmento de la consulta general de los datos,
* y el boton flotante que permite asu vez cargar otro fragmento para añadir mas cardsview*/

public class ItinerarioActivity extends AppCompatActivity {

    //variables para el boton, y el icono buscar y el fragmento
    FloatingActionButton fabAddReservation;
    ImageButton busqueda;
    ListItinerarioFragment listafragmento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerario);

       //enlazar fragmento
        listafragmento= new ListItinerarioFragment();
        //Cargar fragmento por default
        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorF,listafragmento).commit();


        //creando la BD, abriendo la conexion
        dbHelper dbhelper = new dbHelper(ItinerarioActivity.this);
        SQLiteDatabase db = dbhelper.getWritableDatabase(); //objeto para escribir en BD
        SQLiteDatabase dbr = dbhelper.getReadableDatabase(); //objeto para leer en BD


        //cargar el dialogo de calendario para seleccionar la fecha de busqueda
        //enlazado
        busqueda= findViewById(R.id.buscar);
        //Evento
        busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ItinerarioActivity.this, "Diste click en busqueda", Toast.LENGTH_SHORT).show();
                abrircalendario();
            }
        });

        //agregar una nueva tarjeta
        //enlazado
        fabAddReservation = findViewById(R.id.fab_add_reservation);
        // Agregar evento al botón flotante
        fabAddReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aquí es donde manejarás el evento del botón flotante
                Toast.makeText(ItinerarioActivity.this, "¡Has dado clic en el botón flotante!", Toast.LENGTH_SHORT).show();

                //validacion si existe BD inserta en Bd, esta es para el momento que se cree una nueva card
               /* if (db != null) //si la bd se creo  manda a insertar
                {
                    dbhelper.inserta(db);
                    Toast.makeText(ItinerarioActivity.this, "Inserté datos", Toast.LENGTH_LONG);
                }
                else { //si no error
                    Toast.makeText(ItinerarioActivity.this, "Error al insertar Base de datos", Toast.LENGTH_LONG).show();
                }

                 dbhelper.consultar(dbr);

                Toast.makeText(ItinerarioActivity.this, "datos inserto"+dbr, Toast.LENGTH_SHORT).show();
                */
            }
        });
    }

    //metodo que rescata la fecha seleccionada del calendario para poder consultarla
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