package com.example.itinerarioapp.Adaptadores;


import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
        // Obtener la tarjeta actual
        Tarjeta tarjeta = tarjetaList.get(position);

        // Asignar valores a los TextViews
        holder.area.setText(tarjeta.getArea());
        holder.Fecha.setText(tarjeta.getFecha());
        holder.HoraI.setText(tarjeta.getHoraI());
        holder.HoraF.setText(tarjeta.getHoraF());
        holder.Tel.setText(tarjeta.getTel());
        holder.Nom.setText(tarjeta.getNom());
        holder.Act.setText(tarjeta.getAct());

        // Asignar el ID de la tarjeta al campo correspondiente
        holder.itemView.setTag(tarjeta.getId());

        // Obtener el teléfono para el botón
        final String telefono = tarjeta.getTel();
        final String idC= String.valueOf(tarjeta.getId());

        // Configurar OnClickListener para el botón del teléfono
        holder.imgtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Precionaste la tarjeta"+idC, Toast.LENGTH_SHORT).show();
                telefonoClickListener.onTelefonoClick(telefono); // Llamar al método de la interfaz
            }
        });

        // Configurar OnLongClickListener para la CardView
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Mostrar un diálogo de confirmación
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirmación");
                builder.setMessage("¿Deseas borrar esta tarjeta?");

                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Eliminar la tarjeta de la lista
                        tarjetaList.remove(holder.getAdapterPosition());
                        // Notificar al adaptador sobre el cambio
                        notifyDataSetChanged();
                        // Mostrar un mensaje indicando que la tarjeta fue borrada
                        Toast.makeText(context, "Tarjeta "+idC+" borrada", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cancelar el borrado de la tarjeta
                        dialog.dismiss();
                    }
                });
                builder.show();
                return true;
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
