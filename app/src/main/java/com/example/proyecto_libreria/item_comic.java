package com.example.proyecto_libreria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class item_comic extends AppCompatActivity
{

    private TextView ID_ComicC;
    private TextView NombreC;
    private TextView AutorC;
    private TextView Num_PaginasC;
    private TextView PrecioC;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_comic);
        // ----------------------------------------------
        ID_ComicC = (TextView) findViewById(R.id.Id_txt_C);
        NombreC = (TextView) findViewById(R.id.TituloDelComic_txt);
        AutorC = (TextView) findViewById(R.id.AutorC_txt);
        Num_PaginasC = (TextView) findViewById(R.id.Numero_paginasC_txt);
        PrecioC = (TextView) findViewById(R.id.PrecioC_txt);
    }
}