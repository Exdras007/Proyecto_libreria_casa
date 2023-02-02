package com.example.proyecto_libreria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.proyecto_libreria.modelo.libreriaDB;

public class activity_borrar_comic extends AppCompatActivity
{

    private EditText ID_borrarComic;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_comic);
        // ----------------------------------------------
        ID_borrarComic = (EditText) findViewById(R.id.edt_IDaBorrarC);
    }

    public void Volver(View view)
    {
        Intent intent = new Intent(this, activity_comics.class);
        startActivity(intent);
    }

    public void BorrarComic(View view)
    {
        String ID_Comic = String.valueOf(ID_borrarComic.getText());

        if(ID_Comic.isEmpty())
        {
            ID_borrarComic.setError("Debes poner al menos un ID");
            return;
        }

        // -----------------------------------------------------------------------------------------

        AlertDialog.Builder alerta_borrar = new AlertDialog.Builder(this);
        alerta_borrar.setTitle("¿Seguro que quieres borrar el comic?");

        alerta_borrar.setPositiveButton("si", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                libreriaDB.borrarComic(ID_Comic);
                boolean comicBorrado = libreriaDB.borrarLibro(ID_Comic);
                if(comicBorrado == true)
                {
                    Log.i("Borrar", "Se ha borrado el comic");
                }
                else
                {
                    Log.i("Borrar", "No se ha borrado el comic");
                }
            }
        });
        alerta_borrar.setNegativeButton("no", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Log.i("MYSQL", "Vale, bien cancelado");
            }
        });
        alerta_borrar.show();
    }
}