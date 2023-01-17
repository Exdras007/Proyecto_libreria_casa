package com.example.proyecto_libreria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.proyecto_libreria.clases.Libro;
import com.example.proyecto_libreria.modelo.libreriaDB;
import java.util.ArrayList;

public class activity_libros extends AppCompatActivity
{
    private RecyclerView rv_libros;
    private ListaLibrosAdapter adaptadorLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);
        rv_libros = findViewById(R.id.rv_libros);
        // -------- Recoger de la base de datos --------
        ArrayList<Libro> libros_devueltos = libreriaDB.obtenerLibros();

        if(libros_devueltos != null)
        {
            for(Libro l : libros_devueltos)
            {
                Log.i("libros", l.toString());
            }
        }
        else
        {
            Log.i("libros", "No se puedo obtener los datos");
        }
        adaptadorLibros = new ListaLibrosAdapter(this,libros_devueltos);
        rv_libros.setAdapter(adaptadorLibros);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            // Esto es en landscape
            rv_libros.setLayoutManager(new GridLayoutManager(this, 3));
        }
        else
        {
            // Esto es en portrait
            rv_libros.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    public void ir_inicio(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void ir_comics(View view)
    {
        Intent intent = new Intent(this, activity_comics.class);
        startActivity(intent);
    }

    public void Ir_NuevoLibro(View view)
    {
        Intent intent = new Intent(this, Insertar_libro.class);
        startActivity(intent);
    }
}