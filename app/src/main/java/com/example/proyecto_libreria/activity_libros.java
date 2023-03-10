package com.example.proyecto_libreria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.proyecto_libreria.clases.Libro;
import com.example.proyecto_libreria.modelo.libreriaDB;
import java.util.ArrayList;

public class activity_libros extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    private RecyclerView rv_libros;
    private ListaLibrosAdapter adaptadorLibros;
    private Spinner sp_autores;
    private String autor_seleccionado;
    private ArrayList<String> autores;
    private ArrayList<Libro> LibritosDevueltos;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);
        rv_libros = findViewById(R.id.rv_libros);
        swipeRefreshLayout = findViewById(R.id.Refrescar);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                ArrayList<Libro> libros_devueltos = libreriaDB.obtenerLibros();
                CrearRV();
                // ------------------------------------
                adaptadorLibros.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        // -------- Recoger de la base de datos --------
        ArrayList<Libro> libros_devueltos = libreriaDB.obtenerLibros();
        LibritosDevueltos = libros_devueltos;
        CrearRV();
    }

    private void CrearRV()
    {
        if(LibritosDevueltos != null)
        {
            for(Libro l : LibritosDevueltos)
            {
                Log.i("libros", l.toString());
            }
        }
        else
        {
            Log.i("libros", "No se puedo obtener los datos");
        }
        adaptadorLibros = new ListaLibrosAdapter(this, LibritosDevueltos);
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

        sp_autores = (Spinner) findViewById(R.id.sp_autores);

        if(sp_autores != null)
        {
            ArrayList<String> autores = libreriaDB.obtenerAutores();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.activity_item_autor, autores);
            adapter.setDropDownViewResource(R.layout.activity_item_autor);
            sp_autores.setAdapter(adapter);
            sp_autores.setOnItemSelectedListener(this);
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

    public void Ir_BorrarLibro(View view)
    {
        Intent intent = new Intent(this, activity_borrar_libro.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        autor_seleccionado = adapterView.getItemAtPosition(i).toString();
        String AutorFiltrar = autor_seleccionado;
        ArrayList<Libro> libros_devueltos = libreriaDB.filtrarPorAutor(AutorFiltrar);

        if(libros_devueltos != null)
        {
            for(Libro ldf : libros_devueltos)
            {
                Log.i("libros", ldf.toString());
            }
        }
        else
        {
            Log.i("libros", "No se puedo obtener los datos");
        }
        adaptadorLibros = new ListaLibrosAdapter(this, libros_devueltos);
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

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
}