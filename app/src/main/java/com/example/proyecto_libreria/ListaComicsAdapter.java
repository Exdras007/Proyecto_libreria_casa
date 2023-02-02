package com.example.proyecto_libreria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyecto_libreria.clases.Comic;
import java.util.ArrayList;

public class ListaComicsAdapter extends RecyclerView.Adapter<ComicViewHolder>
{
    // Atributos
    private Context contexto;
    private ArrayList<Comic> comics;
    private LayoutInflater inflate;

    public ListaComicsAdapter (Context contexto, ArrayList<Comic> comics)
    {
        this.contexto = contexto;
        this.comics = comics;
        inflate = LayoutInflater.from(this.contexto);
    }

    public Context getContexto()
    {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Comic> getComics() {
        return comics;
    }

    public void setComics(ArrayList<Comic> comics) {
        this.comics = comics;
    }

    public LayoutInflater getInflater() {
        return inflate;
    }

    public void setInflater(LayoutInflater inflater) {
        this.inflate = inflater;
    }

    @NonNull
    @Override
    public ComicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        inflate = LayoutInflater.from(contexto);
        View mItemView = inflate.inflate(R.layout.activity_item_comic, parent,false);
        ComicViewHolder cvh = new ComicViewHolder(mItemView, this);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ComicViewHolder holder, int position)
    {
        Comic c = this.comics.get(position);
        holder.getTxt_item_id_comic().setText(c.getID());
        holder.getTxt_item_tituloC().setText(c.getNombre());
        holder.getTxt_item_autorC().setText(c.getAutor());
        holder.getTxt_item_num_pagC().setText(String.valueOf(c.getPaginas()));
        holder.getTxt_item_precioC().setText(String.valueOf(c.getPrecio()) + " €");
    }

    @Override
    public int getItemCount()
    {
        return comics.size();
    }
}
