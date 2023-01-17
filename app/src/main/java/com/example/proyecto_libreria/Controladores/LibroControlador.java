package com.example.proyecto_libreria.Controladores;

import com.example.proyecto_libreria.Tareas.TareaObtenerLibros;
import com.example.proyecto_libreria.clases.Libro;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class LibroControlador
{

    public static boolean guardarLibro(Libro l)
    {
        // Hola muy buenas

        FutureTask t = new FutureTask(new TareaObtenerLibros());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            return insercionOK;
        }
    }

    public static ArrayList<Libro> obtenerLosLibros()
    {
        FutureTask t = new FutureTask(new TareaObtenerLibros());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        ArrayList<Libro> libros = new ArrayList<Libro>();
        try {
            libros = (ArrayList<Libro>) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
        finally
        {
            return libros;
        }
    }
}