package com.example.proyecto_libreria.Tareas;

import com.example.proyecto_libreria.clases.Libro;
import com.example.proyecto_libreria.modelo.libreriaDB;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class TareaObtenerLibros implements Callable<ArrayList<Libro>>
{

    @Override
    public ArrayList<Libro> call() throws Exception
    {
        ArrayList<Libro> libros = libreriaDB.obtenerLibros();
        return null;
    }
}
