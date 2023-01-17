package com.example.proyecto_libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.proyecto_libreria.clases.Comic;
import com.example.proyecto_libreria.clases.Libro;
import com.example.proyecto_libreria.modelo.libreriaDB;

import java.util.ArrayList;

public class activity_comics extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);

        // -------- Recoger de la base de datos --------
        ArrayList<Comic> comics_devueltos = libreriaDB.obtenerComics();

        if(comics_devueltos != null)
        {
            for(Comic c : comics_devueltos)
            {
                Log.i("comics", c.toString());
            }
        }
        else
        {
            Log.i("comics", "No se puedo obtener los datos");
        }
    }

    public void ir_inicio(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void ir_libros(View view)
    {
        Intent intent = new Intent(this, activity_libros.class);
        startActivity(intent);
    }
}