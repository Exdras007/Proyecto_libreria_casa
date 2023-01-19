package com.example.proyecto_libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_editar_libro extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_libro);
    }

    public void Volver(View view)
    {
        Intent intent = new Intent(this, activity_libros.class);
        startActivity(intent);
    }
}