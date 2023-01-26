package com.example.proyecto_libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.proyecto_libreria.clases.Libro;

public class activity_editar_libro extends AppCompatActivity
{

    private TextView Titulo_detalles;
    private TextView Autor_detalles;
    private TextView Num_Paginas_detalles;
    private TextView Precio_detalles;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_libro);

        Titulo_detalles = (TextView) findViewById(R.id.edt_editar_titulo_libro);
        Autor_detalles = (TextView) findViewById(R.id.edt_editar_autor_libro);
        Num_Paginas_detalles = (TextView) findViewById(R.id.edt_editar_paginas_libro);
        Precio_detalles = (TextView) findViewById(R.id.edt_editar_precio_libro);
        /*
        Intent intent = getIntent();
        if(intent != null)
        {
            Libro l = (Libro) intent.getSerializableExtra(LibroViewHolder.EXTRA_LIBRO_ITEM);
            Titulo_detalles.setText(l.getNombre());
            Autor_detalles.setText(l.getAutor());
            Num_Paginas_detalles.setText(String.valueOf(l.getPaginas()));
            Precio_detalles.setText(String.valueOf(l.getPrecio()));
        }
         */
    }

    public void Volver(View view)
    {
        Intent intent = new Intent(this, activity_libros.class);
        startActivity(intent);
    }

    public void Actualizar(View view)
    {

    }
}