package com.utp.petfriendly.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.utp.petfriendly.R;
import com.utp.petfriendly.model.AdopcionModel;

import java.util.ArrayList;
import java.util.List;

public class AdopcionAdapter extends RecyclerView.Adapter<AdopcionAdapter.ViewHolder> {

    private Context context;
    private List<AdopcionModel> lista = new ArrayList<>();
    private static ClickListener clickListener;

    public AdopcionAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adopcion_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(context, lista.get(position));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public  void  setItemAdopcion(List<AdopcionModel> listaAdopcion){
        this.lista = listaAdopcion;
        Log.e("xxx",""+lista.size());
        notifyDataSetChanged();
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        AdopcionAdapter.clickListener = clickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtRaza, txtTamanio,txtRangoEdad,txtEspecialidad;
        ImageView imgPet;
       // CardView cardView;

        public ViewHolder(@NonNull View view) {
            super(view);
            imgPet =  view.findViewById(R.id.imgPet);
            txtRaza = view.findViewById(R.id.txtRaza);
            txtTamanio = view.findViewById(R.id.txtTamanio);
            txtRangoEdad = view.findViewById(R.id.txtRangoEdad);
            txtEspecialidad = view.findViewById(R.id.txtEspecialidad);
           // cardView = view.findViewById(R.id.cardView);
        }

        public void bind(Context context, AdopcionModel item) {
            txtRaza.setText(item.getRaza());
            txtTamanio.setText(item.getTamanio());
            txtRangoEdad.setText(item.getRangoEdad());
            txtEspecialidad.setText(item.getEspecialidad());
            Log.e("iamge",""+item.getImagen());
            if(item.getImagen() != null){
                Log.e("iamge",""+item.getImagen());
               Picasso.with(context).load(item.getImagen()).into(imgPet);
               // Picasso.with(getRaza).load(notificacionModel.getUrlImagen()).into(image);
              //  Picasso.get().load(item.getImagen()).into(imgPet);
            }
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);
        }
    }
}
