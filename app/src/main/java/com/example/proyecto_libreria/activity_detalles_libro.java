package com.example.proyecto_libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.proyecto_libreria.clases.Libro;

public class activity_detalles_libro extends AppCompatActivity
{
    private TextView ID_detalles;
    private TextView Titulo_detalles;
    private TextView Autor_detalles;
    private TextView Num_Paginas_detalles;
    private TextView Precio_detalles;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_libro);

        ID_detalles = (TextView) findViewById(R.id.txt_id_libro);
        Titulo_detalles = (TextView) findViewById(R.id.txt_detalles_TituloDelLibro);
        Autor_detalles = (TextView) findViewById(R.id.txt_detalles_autor);
        Num_Paginas_detalles = (TextView) findViewById(R.id.txt_num_paginas);
        Precio_detalles = (TextView) findViewById(R.id.txt_precio);
        // --------------
        Intent intent = getIntent();
        if(intent != null)
        {
            Libro l = (Libro) intent.getSerializableExtra(LibroViewHolder.EXTRA_LIBRO_ITEM);
            ID_detalles.setText(l.getID());
            Titulo_detalles.setText(l.getNombre());
            Autor_detalles.setText(l.getAutor());
            Num_Paginas_detalles.setText(String.valueOf(l.getPaginas()));
            Precio_detalles.setText(String.valueOf(l.getPrecio()) + " €");
        }
    }

    public void EditarLibro(View view)
    {
        Intent intent = new Intent(this, activity_editar_libro.class);
        startActivity(intent);
    }

    public void Volver(View view)
    {
        Intent intent = new Intent(this, activity_libros.class);
        startActivity(intent);
    }
}