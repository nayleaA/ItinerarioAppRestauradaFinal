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
import com.example.itinerarioapp.Objetos.Tarjeta;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Locale;

/* Clase principal dela carga de elementos de la aplicacion,
* carga la toolbar, el fragmento de la consulta general de los datos,
* y el boton flotante que permite asu vez cargar otro fragmento para añadir mas cardsview*/

public class ItinerarioActivity extends AppCompatActivity {

    //variables para el boton, y el icono buscar y el fragmento
    FloatingActionButton fabAddReservation;
    ImageButton busqueda;
    ListItinerarioFragment listafragmento;
    private dbHelper dbHelper; // Instancia de dbHelper


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerario);

        dbHelper = new dbHelper(this); // Inicializa dbHelper

        //enlazar fragmento
        listafragmento= new ListItinerarioFragment();
        //Cargar fragmento por default
        getSupportFragmentManager().beginTransaction().add(R.id.ContenedorF,listafragmento).commit();


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
            }
        });
    }

    //metodo que rescata la fecha seleccionada del calendario para poder consultarla
    public void abrircalendario() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = year + "-" + (month + 1) + "-" + day;

                // Formatear la fecha seleccionada
                String formattedDate = String.format(Locale.getDefault(), "%d-%02d-%02d", year, month + 1, day);

                // Llama al método cargarDatosF en el fragmento
                listafragmento.cargarDatosF(formattedDate);
                Toast.makeText(ItinerarioActivity.this, "La fecha es "+formattedDate, Toast.LENGTH_SHORT).show();

            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}