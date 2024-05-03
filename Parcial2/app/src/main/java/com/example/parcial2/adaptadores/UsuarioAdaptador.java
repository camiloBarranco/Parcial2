package com.example.parcial2.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.parcial2.R;
import com.example.parcial2.clases.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UsuarioAdaptador extends RecyclerView.Adapter<UsuarioAdaptador.ViewHolder> {

    private List<Usuario> datos;
    final UsuarioAdaptador.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Usuario dato);
    }
    public UsuarioAdaptador(List<Usuario> datos,UsuarioAdaptador.OnItemClickListener listener) {
        this.datos = datos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UsuarioAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);

        return new ViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioAdaptador.ViewHolder holder, int position) {
        Usuario dato = datos.get(position);
        holder.bind(dato);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_nombre_usuario, txt_descripcion_usuario,txt_estado_usuario;
        ImageView img_usuario;
        UsuarioAdaptador.OnItemClickListener listener;



        public ViewHolder(@NonNull View itemView, UsuarioAdaptador.OnItemClickListener listener) {
            super(itemView);
            txt_nombre_usuario = (TextView) itemView.findViewById(R.id.txt_nombre_usuario);
            txt_descripcion_usuario = (TextView) itemView.findViewById(R.id.txt_descripcion_usuario);
            txt_estado_usuario = (TextView) itemView.findViewById(R.id.txt_estado_usuario);
            img_usuario = (ImageView) itemView.findViewById(R.id.img_usuario);
            this.listener = listener; // Asignar el listener aquí

        }

        public void bind(Usuario dato){
            txt_nombre_usuario.setText(dato.getNombre());
            txt_descripcion_usuario.setText(dato.getDescripcion());
            txt_estado_usuario.setText(dato.getEstado());
            Picasso.get().load(dato.getImagen()).into(img_usuario);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onItemClick(dato);
                    }
                }
            });
        }
    }
}
