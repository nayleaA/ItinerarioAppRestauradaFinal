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

/**
 * Adaptador para la lista de tarjetas.
 * Este adaptador se encarga de manejar la presentación de las tarjetas en un RecyclerView.
 */
public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.ViewHolder> {

    private List<Tarjeta> tarjetaList; // Lista de tarjetas
    private Context context; // Contexto de la aplicación
    private OnTelefonoClickListener telefonoClickListener; // Interfaz para manejar el clic en el botón del teléfono

    /**
     * Constructor de la clase.
     * @param tarjetaList Lista de tarjetas a mostrar.
     * @param context Contexto de la aplicación.
     * @param telefonoClickListener Interfaz para manejar el clic en el botón del teléfono.
     */
    public AdaptadorLista(List<Tarjeta> tarjetaList, Context context, OnTelefonoClickListener telefonoClickListener) {
        this.tarjetaList = tarjetaList;
        this.context = context;
        this.telefonoClickListener = telefonoClickListener;
    }

    /**
     * Método invocado cuando se necesita crear una nueva vista del elemento de la lista.
     * @param parent Grupo al que pertenece la vista.
     * @param viewType Tipo de la vista.
     * @return ViewHolder con la vista del elemento de la lista.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcardview, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Método invocado para asociar datos a una vista.
     * @param holder ViewHolder de la vista.
     * @param position Posición del elemento en la lista.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tarjeta tarjeta = tarjetaList.get(position); // Obtener la tarjeta actual

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

        final String telefono = tarjeta.getTel(); // Obtener el teléfono para el botón
        final String idC = String.valueOf(tarjeta.getId());

        // Configurar OnClickListener para el botón del teléfono
        holder.imgtel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                        Toast.makeText(context, "Tarjeta " + idC + " borrada", Toast.LENGTH_SHORT).show();
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

    /**
     * Método que devuelve el número total de elementos en el conjunto de datos.
     * @return Número total de elementos.
     */
    @Override
    public int getItemCount() {
        return tarjetaList.size();
    }

    /**
     * Clase ViewHolder que representa una vista del elemento de la lista.
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView area, Fecha, HoraI, HoraF, Tel, Nom, Act; // Componentes de la tarjeta
        ImageView imgtel; // Botón del teléfono

        /**
         * Constructor de la clase ViewHolder.
         * @param itemView Vista del elemento de la lista.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Enlazar componentes diseñados en layout-tarjeta
            area = itemView.findViewById(R.id.arear);
            Fecha = itemView.findViewById(R.id.fechar);
            HoraF = itemView.findViewById(R.id.horafr);
            HoraI = itemView.findViewById(R.id.horair);
            Tel = itemView.findViewById(R.id.telr);
            Nom = itemView.findViewById(R.id.namer);
            Act = itemView.findViewById(R.id.descact);

            // Enlazar ImageView
            imgtel = itemView.findViewById(R.id.imgtel);
        }
    }

    /**
     * Interfaz para manejar el clic en el botón del teléfono.
     */
    public interface OnTelefonoClickListener {
        void onTelefonoClick(String telefono);
    }

    // En el adaptador AdaptadorLista, agrega un método para actualizar los datos
    public void actualizarDatos(List<Tarjeta> nuevaLista) {
        tarjetaList.clear(); // Borra los datos existentes
        tarjetaList.addAll(nuevaLista); // Agrega los nuevos datos
        notifyDataSetChanged(); // Notifica al RecyclerView que los datos han cambiado
    }
}
