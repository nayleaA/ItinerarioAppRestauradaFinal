package com.example.itinerarioapp.FRAGEMTS;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itinerarioapp.R;

public class ListItinerarioFechaFragment extends Fragment {

    public ListItinerarioFechaFragment() {
        // Required empty public constructor
    }

    public static ListItinerarioFechaFragment newInstance(String param1, String param2) {
        ListItinerarioFechaFragment fragment = new ListItinerarioFechaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_itinerario_fecha, container, false);
    }
}