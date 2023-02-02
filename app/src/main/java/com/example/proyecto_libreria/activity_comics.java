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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.proyecto_libreria.clases.Comic;
import com.example.proyecto_libreria.clases.Libro;
import com.example.proyecto_libreria.modelo.libreriaDB;

import java.util.ArrayList;

public class activity_comics extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner sp_autoresC;
    private ArrayList<String> autoresC;

    private ListaComicsAdapter adaptadorComics;
    private RecyclerView rv_comics;
    private String autor_seleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics);
        rv_comics = findViewById(R.id.rv_comics);
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

        sp_autoresC = (Spinner) findViewById(R.id.sp_autoresC);
        rv_comics.setAdapter(adaptadorComics);
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            rv_comics.setLayoutManager((new GridLayoutManager(this, 3)));
        }
        else
        {
            rv_comics.setLayoutManager(new LinearLayoutManager(this));
        }

        sp_autoresC = (Spinner) findViewById(R.id.sp_autoresC);

        if (sp_autoresC != null)
        {
            ArrayList<String> autoresC = libreriaDB.obtenerAutoresC();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.activity_item_autor, autoresC);
            adapter.setDropDownViewResource(R.layout.activity_item_autor);
            sp_autoresC.setAdapter(adapter);
            sp_autoresC.setOnItemSelectedListener(this);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        autor_seleccionado = adapterView.getItemAtPosition(i).toString();
        String AutorFiltrarC = autor_seleccionado;
        ArrayList<Comic> comics_devueltos = libreriaDB.filtrarPorAutorC(AutorFiltrarC);

        if(comics_devueltos != null)
        {
            for(Comic cdf : comics_devueltos)
            {
                Log.i("comics", cdf.toString());
            }
        }
        else
        {
            Log.i("comics", "No se pudo obtener los datos");
        }
        adaptadorComics = new ListaComicsAdapter(this, comics_devueltos);
        rv_comics.setAdapter(adaptadorComics);
        int orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            rv_comics.setLayoutManager((new GridLayoutManager(this, 3)));
        }
        else
        {
            rv_comics.setLayoutManager(new LinearLayoutManager(this));
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }

    public void Ir_NuevoLibro(View view)
    {

    }

    public void Ir_BorrarLibro(View view)
    {
        Intent intent = new Intent(this, activity_borrar_comic.class);
        startActivity(intent);
    }
}