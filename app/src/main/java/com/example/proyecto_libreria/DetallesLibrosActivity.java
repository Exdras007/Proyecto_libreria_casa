package com.example.proyecto_libreria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_libreria.clases.Libro;

public class DetallesLibrosActivity extends AppCompatActivity
{
    private TextView txt_id_libro;
    private TextView txt_titulo;
    private TextView txt_autor;
    private TextView txt_num_paginas;
    private TextView txt_precio;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_libro);
        // ---------------------------------
        txt_id_libro = (TextView) findViewById(R.id.Id_txt);
        txt_titulo = (TextView) findViewById(R.id.TituloDelLibro_txt);
        txt_autor = (TextView) findViewById(R.id.Autor_txt);
        txt_num_paginas = (TextView) findViewById(R.id.Numero_paginas_txt);
        txt_precio = (TextView) findViewById(R.id.Precio_txt);
        // -------------
        Intent intent = getIntent();
        if(intent != null)
        {
            Libro l = (Libro) intent.getSerializableExtra(LibroViewHolder.EXTRA_LIBRO_ITEM);
            txt_id_libro.setText(l.getID());
            txt_titulo.setText(l.getNombre());
            txt_autor.setText(l.getAutor());
            txt_num_paginas.setText(String.valueOf(l.getPaginas()));
            txt_precio.setText(String.valueOf(l.getPrecio()));
        }
        else
        {
            Log.i("libros", "No se ha podido realizar la operacion");
        }
    }
}
