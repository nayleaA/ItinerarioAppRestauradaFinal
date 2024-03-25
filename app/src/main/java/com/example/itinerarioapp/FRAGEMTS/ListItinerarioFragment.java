package com.example.itinerarioapp.FRAGEMTS;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itinerarioapp.Adaptadores.AdaptadorLista;
import com.example.itinerarioapp.Objetos.Tarjeta;
import com.example.itinerarioapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragmento para mostrar una lista de itinerarios.
 * Este fragmento se encarga de cargar y mostrar una lista de itinerarios utilizando un RecyclerView.
 */
public class ListItinerarioFragment extends Fragment implements AdaptadorLista.OnTelefonoClickListener {

    private RecyclerView recyclerView; // RecyclerView para mostrar la lista de itinerarios
    private AdaptadorLista adaptadorLista; // Adaptador para el RecyclerView

    /**
     * Constructor de la clase.
     */
    public ListItinerarioFragment() {
    }

    /**
     * Método invocado al crear el fragmento.
     * @param savedInstanceState Instancia guardada del estado anterior.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Método invocado para crear la vista del fragmento.
     * @param inflater Objeto para inflar la vista.
     * @param container Contenedor de la vista.
     * @param savedInstanceState Instancia guardada del estado anterior.
     * @return Vista creada del fragmento.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_itinerario, container, false);
        recyclerView = view.findViewById(R.id.listarecycler);
        cargarDatos(); // Cargar los datos de la lista
        return view;
    }

    /**
     * Método privado para cargar los datos de la lista de itinerarios.
     */
    private void cargarDatos() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Crear una lista de tarjetas con datos de ejemplo
        List<Tarjeta> lista = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            lista.add(new Tarjeta(i, "Informatica", "hoy", "11:57", "12", "3421096968", "nay", "una"));
        }

        // Inicializar el adaptador con la lista de tarjetas y el contexto actual
        adaptadorLista = new AdaptadorLista(lista, getContext(), this);
        recyclerView.setAdapter(adaptadorLista);
    }

    /**
     * Método invocado cuando se hace clic en el botón del teléfono en una tarjeta.
     * @param telefono Número de teléfono asociado al itinerario.
     */
    @Override
    public void onTelefonoClick(String telefono) {
        // Abrir el marcador de teléfono con el número seleccionado
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + telefono));
        startActivity(intent);
    }
}
