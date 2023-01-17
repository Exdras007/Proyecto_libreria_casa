package com.example.proyecto_libreria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyecto_libreria.clases.Libro;
import java.util.ArrayList;

public class ListaLibrosAdapter extends RecyclerView.Adapter<LibroViewHolder>
{
    // Atributos
    private Context contexto;
    private ArrayList<Libro> libros;
    private LayoutInflater inflate;

    public ListaLibrosAdapter(Context contexto, ArrayList<Libro> libros)
    {
        this.contexto = contexto;
        this.libros = libros;
        inflate = LayoutInflater.from(this.contexto);
    }

    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        inflate = LayoutInflater.from(contexto);
        View mItemView = inflate.inflate(R.layout.activity_item_libro,parent,false);
        LibroViewHolder lvh = new LibroViewHolder(mItemView, this);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder holder, int position)
    {
        Libro l = this.libros.get(position);
        holder.getTxt_item_id_libro().setText(l.getID());
        holder.getTxt_item_titulo().setText(l.getNombre());
        holder.getTxt_item_autor().setText(l.getAutor());
        holder.getTxt_item_num_pag().setText(String.valueOf(l.getPaginas()));
        holder.getTxt_item_precio().setText(String.valueOf(l.getPrecio()) + " €");
    }

    @Override
    public int getItemCount()
    {
        return libros.size();
    }
}
