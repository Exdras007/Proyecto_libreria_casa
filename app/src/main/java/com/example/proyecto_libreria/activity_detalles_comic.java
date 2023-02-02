package com.example.proyecto_libreria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.proyecto_libreria.clases.Comic;

public class activity_detalles_comic extends AppCompatActivity
{
    private TextView ID_detallesC;
    private TextView Titulo_detallesC;
    private TextView Autor_detallesC;
    private TextView Num_paginas_detallesC;
    private TextView Precio_detallesC;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_comic);

        ID_detallesC = (TextView) findViewById(R.id.txt_id_comic);
        Titulo_detallesC = (TextView) findViewById(R.id.txt_detalles_TituloDelComic);
        Autor_detallesC = (TextView) findViewById(R.id.txt_detalles_AutorC);
        Num_paginas_detallesC = (TextView) findViewById(R.id.txt_detalles_PaginasC);
        Precio_detallesC = (TextView) findViewById(R.id.txt_precioC);
        // -------
        Intent intent = getIntent();
        if(intent != null)
        {
            Comic c = (Comic) intent.getSerializableExtra(ComicViewHolder.EXTRA_COMIC_ITEM);
            ID_detallesC.setText(c.getID());
            Titulo_detallesC.setText(c.getNombre());
            Autor_detallesC.setText(c.getAutor());
            Num_paginas_detallesC.setText(String.valueOf(c.getPaginas()));
            Precio_detallesC.setText(String.valueOf(c.getPrecio()) + " €");
        }
    }

    public void Volver(View view)
    {
        Intent intent = new Intent(this, activity_comics.class);
        startActivity(intent);
    }
}