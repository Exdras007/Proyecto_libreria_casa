package com.example.proyecto_libreria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.proyecto_libreria.clases.Libro;
import com.example.proyecto_libreria.modelo.libreriaDB;

public class activity_borrar_libro extends AppCompatActivity
{

    private EditText ID_borrarLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_libro);
        // ---------------------------------------------
        ID_borrarLibro = (EditText) findViewById(R.id.edt_IDaBorrar);
    }

    public void BorrarLibro(View view)
    {
        String ID_Libro = String.valueOf(ID_borrarLibro.getText());

            if (ID_Libro.isEmpty())
            {
                ID_borrarLibro.setError("Debes poner al menos un ID");
                return;
            }

        // -----------------------------------------------------------------------------------------

        AlertDialog.Builder alerta_borrar = new AlertDialog.Builder(this);
        alerta_borrar.setTitle("¿Seguro que quieres borrar el libro?");

        alerta_borrar.setPositiveButton("si", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                libreriaDB.borrarLibro(ID_Libro);
                boolean libroBorrado = libreriaDB.borrarLibro(ID_Libro);
                if(libroBorrado == true)
                {
                    Log.i("Borrar", "Se ha borrado el libro");
                }
                else
                {
                    Log.i("Borrar", "No se ha borrado el libro");
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

    public void Volver(View view)
    {
        Intent intent = new Intent(this, activity_libros.class);
        startActivity(intent);
    }
}