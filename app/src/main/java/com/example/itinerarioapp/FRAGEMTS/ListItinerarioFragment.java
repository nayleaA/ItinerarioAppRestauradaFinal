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

public class ListItinerarioFragment extends Fragment  implements AdaptadorLista.OnTelefonoClickListener{

    RecyclerView recyclerView;
    AdaptadorLista adaptadorLista;

    //constructor
    public ListItinerarioFragment() {
    }

    //Crear el fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //crear el diseño del fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_itinerario, container, false);
        recyclerView = view.findViewById(R.id.listarecycler);
        cargarDatos(); // Llama a cargarDatos() aquí
        return view;
    }

    private void cargarDatos() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Tarjeta> lista = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lista.add(new Tarjeta(i, "Informatica", "hoy", "11:57", "12", "3421096968", "nay", "una"));
        }

        adaptadorLista = new AdaptadorLista(lista, getContext(), (AdaptadorLista.OnTelefonoClickListener) this);
        recyclerView.setAdapter(adaptadorLista);
    }

    @Override
    public void onTelefonoClick(String telefono) {
        // Abrir el marcador de teléfono
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + telefono));
        startActivity(intent);
    }
}
