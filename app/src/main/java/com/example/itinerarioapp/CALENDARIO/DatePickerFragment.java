package com.example.itinerarioapp.CALENDARIO;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

/* Esta clase crea un calendario, rescata el valor clickeado de fecha dentro del calendario y lo retorna para usar
*  ese valor en una consulta por fecha.
 * Fragmento para mostrar un selector de fecha.
 * Este fragmento se utiliza para mostrar un cuadro de diálogo que permite al usuario seleccionar una fecha.
 */
public class DatePickerFragment extends DialogFragment {
    private DatePickerDialog.OnDateSetListener listener; // Listener para manejar la selección de fecha

    /**
     * Método estático para crear una nueva instancia del fragmento.
     * @param listener Listener para manejar la selección de fecha.
     * @return Nueva instancia del fragmento DatePickerFragment.
     */
    public static DatePickerFragment newInstance(DatePickerDialog.OnDateSetListener listener) {
        DatePickerFragment fragment = new DatePickerFragment(); // Inicializa un nuevo fragmento
        fragment.setListener(listener); // Establece el listener pasado como argumento
        return fragment;
    }

    /**
     * Método para establecer el listener para manejar la selección de fecha.
     * @param listener Listener para manejar la selección de fecha.
     */
    public void setListener(DatePickerDialog.OnDateSetListener listener) {
        this.listener = listener; // Asigna el listener proporcionado
    }

    /**
     * Método invocado al crear el cuadro de diálogo para seleccionar la fecha.
     * @param savedInstanceState Instancia guardada del estado anterior.
     * @return Cuadro de diálogo para seleccionar la fecha.
     */
    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Obtiene una instancia del calendario con la fecha actual
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR); // Año actual
        int month = c.get(Calendar.MONTH); // Mes actual
        int day = c.get(Calendar.DAY_OF_MONTH); // Día actual

        // Crea y devuelve un nuevo DatePickerDialog con la fecha actual y el listener proporcionado
        return new DatePickerDialog(getActivity(), listener, year, month, day);
    }
}
