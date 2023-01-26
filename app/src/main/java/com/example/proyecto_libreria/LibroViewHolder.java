package com.example.proyecto_libreria;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyecto_libreria.clases.Libro;

public class LibroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public static final String EXTRA_LIBRO_ITEM = "Esdras.libros.com";
    // Atributos
    private TextView txt_item_id_libro;
    private TextView txt_item_titulo;
    private TextView txt_item_autor;
    private TextView txt_item_num_pag;
    private TextView txt_item_precio;
    // -----------------------------------------------------------------
    private ListaLibrosAdapter lla;

    public TextView getTxt_item_id_libro() {
        return txt_item_id_libro;
    }

    public void setTxt_item_id_libro(TextView txt_item_id_libro) {
        this.txt_item_id_libro = txt_item_id_libro;
    }

    public TextView getTxt_item_titulo() {
        return txt_item_titulo;
    }

    public void setTxt_item_titulo(TextView txt_item_titulo) {
        this.txt_item_titulo = txt_item_titulo;
    }

    public TextView getTxt_item_autor() {
        return txt_item_autor;
    }

    public void setTxt_item_autor(TextView txt_item_autor) {
        this.txt_item_autor = txt_item_autor;
    }

    public TextView getTxt_item_num_pag() {
        return txt_item_num_pag;
    }

    public void setTxt_item_num_pag(TextView txt_item_num_pag) {
        this.txt_item_num_pag = txt_item_num_pag;
    }

    public TextView getTxt_item_precio() {
        return txt_item_precio;
    }

    public void setTxt_item_precio(TextView txt_item_precio) {
        this.txt_item_precio = txt_item_precio;
    }

    public ListaLibrosAdapter getLla() {
        return lla;
    }

    public void setLla(ListaLibrosAdapter lla) {
        this.lla = lla;
    }

    public LibroViewHolder(@NonNull View itemView, ListaLibrosAdapter listalibrosAdapter)
    {
        super(itemView); // Esto debe ir lo primero para que herede
        txt_item_id_libro = (TextView) itemView.findViewById(R.id.Id_txt);
        txt_item_titulo = (TextView) itemView.findViewById(R.id.TituloDelLibro_txt);
        txt_item_autor = (TextView) itemView.findViewById(R.id.Autor_txt);
        txt_item_num_pag = (TextView) itemView.findViewById(R.id.Numero_paginas_txt);
        txt_item_precio = (TextView) itemView.findViewById(R.id.Precio_txt);
        // -----------------------------------------------------------------------------------------
        lla = listalibrosAdapter;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        int posicion = getLayoutPosition();
        Libro l = lla.getLibros().get(posicion);
        Intent intent = new Intent(lla.getContexto(), activity_detalles_libro.class);
        intent.putExtra(EXTRA_LIBRO_ITEM, l);
        lla.getContexto().startActivity(intent);
    }
}