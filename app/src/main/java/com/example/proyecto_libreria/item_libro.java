package com.example.proyecto_libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.proyecto_libreria.clases.Libro;

public class item_libro extends AppCompatActivity
{

    private TextView ID_libro;
    private TextView Nombre;
    private TextView Autor;
    private TextView Num_Paginas;
    private TextView Precio;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_libro);
        // -------------------------------------------
        ID_libro = (TextView) findViewById(R.id.Id_txt);
        Nombre = (TextView) findViewById(R.id.TituloDelLibro_txt);
        Autor = (TextView) findViewById(R.id.Autor_txt);
        Num_Paginas = (TextView) findViewById(R.id.Numero_paginas_txt);
        Precio = (TextView) findViewById(R.id.Precio_txt);
        // --------------------------
        Intent intent = getIntent();
        /*
        if(intent != null)
        {
            Libro l = (Libro) intent.getSerializableExtra()
        }
        */
    }
}