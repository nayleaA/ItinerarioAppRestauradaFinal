package com.example.itinerarioapp.Adaptadores;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itinerarioapp.Objetos.Tarjeta;
import com.example.itinerarioapp.R;

import java.util.List;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.ViewHolder>{

    List<Tarjeta> tarjetaList;
    Context context;
    private OnTelefonoClickListener telefonoClickListener; // Referencia a la interfaz


    public AdaptadorLista(List<Tarjeta> tarjetaList, Context context,OnTelefonoClickListener telefonoClickListener) {
        this.tarjetaList = tarjetaList;
        this.context = context;
        this.telefonoClickListener = telefonoClickListener;
    }

    @NonNull
    @Override
    //inflando el componente de la tarjeta
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcardview,parent,false);
        return new ViewHolder(view);
    }

    //Vinculacion de componentes
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Asignar valores a los TextViews
        holder.area.setText(tarjetaList.get(position).getArea());
        holder.Fecha.setText(tarjetaList.get(position).getFecha());
        holder.HoraI.setText(tarjetaList.get(position).getHoraI());
        holder.HoraF.setText(tarjetaList.get(position).getHoraF());
        holder.Tel.setText(tarjetaList.get(position).getTel());
        holder.Nom.setText(tarjetaList.get(position).getNom());
        holder.Act.setText(tarjetaList.get(position).getAct());

        // Obtener el teléfono para el botón
        final String telefono = tarjetaList.get(position).getTel();

        // Configurar OnClickListener para el botón del teléfono
        holder.imgtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                telefonoClickListener.onTelefonoClick(telefono); // Llamar al método de la interfaz
            }
        });
    }


    @Override
    public int getItemCount() {
        return tarjetaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView id,area, Fecha, HoraI,HoraF,Tel,Nom, Act;
        ImageView imgtel;

        //enlazar componentes diseñados en layout-tarjeta
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            area=itemView.findViewById(R.id.arear);
            Fecha=itemView.findViewById(R.id.fechar);
            HoraF=itemView.findViewById(R.id.horafr);
            HoraI=itemView.findViewById(R.id.horair);
            Tel=itemView.findViewById(R.id.telr);
            Nom=itemView.findViewById(R.id.namer);
            Act=itemView.findViewById(R.id.descact);

            // Enlazar ImageView
            imgtel = itemView.findViewById(R.id.imgtel);

        }
    }

    // Definir la interfaz para manejar el clic en el botón del teléfono
    public interface OnTelefonoClickListener {
        void onTelefonoClick(String telefono);
    }
}
