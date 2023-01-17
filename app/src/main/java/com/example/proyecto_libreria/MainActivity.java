package com.example.proyecto_libreria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.proyecto_libreria.clases.Libro;
import com.example.proyecto_libreria.modelo.libreriaDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView rv_libros;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Libro> libros_devueltos_1 = libreriaDB.obtenerLibros();


    }

    public void ir_libros(View view)
    {
        Intent intent = new Intent(this, activity_libros.class);
        startActivity(intent);
    }

    public void ir_comics(View view)
    {
        Intent intent = new Intent(this, activity_comics.class);
        startActivity(intent);
    }

}