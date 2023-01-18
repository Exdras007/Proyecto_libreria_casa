package com.example.proyecto_libreria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.proyecto_libreria.Controladores.LibroControlador;
import com.example.proyecto_libreria.clases.Libro;
import com.example.proyecto_libreria.modelo.libreriaDB;

public class Insertar_libro extends AppCompatActivity
{

    private EditText ID_nuevoLibro;
    private EditText Titulo_nuevoLibro;
    private EditText Autor_nuevoLibro;
    private EditText NumeroPag_nuevoLibro;
    private EditText Precio_nuevoLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_libro);
        // ------------------------------------------------
        ID_nuevoLibro = (EditText) findViewById(R.id.edt_nuevoID);
        Titulo_nuevoLibro = (EditText) findViewById(R.id.edt_nuevoTitulo);
        Autor_nuevoLibro = (EditText) findViewById(R.id.edt_AutorNuevoLibro);
        NumeroPag_nuevoLibro = (EditText) findViewById(R.id.edt_PaginasNuevoLibro);
        Precio_nuevoLibro = (EditText) findViewById(R.id.edt_PrecioNuevoLibro);
    }

    public void Volver(View view)
    {
        Intent intent = new Intent(this, activity_libros.class);
        startActivity(intent);
    }


    public void InsertarLibro(View view)
    {
        String ID_Libro = String.valueOf(ID_nuevoLibro.getText());
        String Titulo_Libro = String.valueOf(Titulo_nuevoLibro.getText());
        String Autor_Libro = String.valueOf(Autor_nuevoLibro.getText());
        String NumeroPaginas_Libro_texto = String.valueOf(NumeroPag_nuevoLibro.getText());
        String Precio_Libro_texto = String.valueOf(Precio_nuevoLibro.getText());

        if(ID_Libro.isEmpty())
        {
            ID_nuevoLibro.setError("Debes poner al menos un ID");
            return;
        }
        if(Titulo_Libro.isEmpty())
        {
            Titulo_nuevoLibro.setError("Debes poner un titulo al libro");
            return;
        }
        if(NumeroPaginas_Libro_texto.isEmpty())
        {
            NumeroPag_nuevoLibro.setError("Debes poner el numero de paginas");
            return;
        }
        if(NumeroPaginas_Libro_texto.startsWith("0"))
        {
            NumeroPag_nuevoLibro.setError("No puedes empezar por 0 o tener 0 paginas");
            return;
        }
        if(Precio_Libro_texto.isEmpty())
        {
            Precio_nuevoLibro.setError("Debes de poner el precio");
            return;
        }

        int NumPaginas_Libro = Integer.parseInt(String.valueOf(NumeroPaginas_Libro_texto));
        double Precio_Libro = Double.valueOf(Precio_Libro_texto);

        //--------------------------------------------------------
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("¿Son correctos los datos?");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Libro l = new Libro(ID_Libro,Titulo_Libro,Autor_Libro,NumPaginas_Libro,Precio_Libro);
                libreriaDB.insertarLibro(l);
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Log.i("MYSQL", "vale, bien cancelado");
            }
        });
        alerta1.show();
    }
}