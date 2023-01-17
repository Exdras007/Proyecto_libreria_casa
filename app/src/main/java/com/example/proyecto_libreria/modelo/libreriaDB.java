package com.example.proyecto_libreria.modelo;

import android.util.Log;
import com.example.proyecto_libreria.clases.Comic;
import com.example.proyecto_libreria.clases.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class libreriaDB
{
    public static ArrayList<Libro> obtenerLibros()
    {
        Connection conexion = ConfiguracionDB.conectarBaseDeDatos();
        if (conexion == null)
        {
            return null;
        }
        ArrayList<Libro> libros = new ArrayList<Libro>();

        try
        {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "SELECT * FROM libros ORDER BY ID_Libro";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while(resultado.next())
            {
                String id_libro = resultado.getString("ID_Libro");
                String nombre = resultado.getString("Nombre");
                String autor = resultado.getString("Autor");
                int num_paginas = resultado.getInt("Num_Paginas");
                Double precio = resultado.getDouble("Precio");
                Libro elLibro = new Libro(id_libro, nombre, autor, num_paginas, precio);
                libros.add(elLibro);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return libros;
        }
        catch (SQLException e)
        {
            Log.i("sql", "Error de SQL");
            e.printStackTrace();
            return libros;
        }
    }

    public static boolean insertarLibro(Libro l)
    {
        Connection conexion = ConfiguracionDB.conectarBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try
        {
            String ordensql = "INSERT INTO libros (ID_Libro, Nombre, Autor, Num_Paginas, Precio) VALUES (?,?,?,?,?);";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);

            sentencia.setString(1, l.getID());
            sentencia.setString(2, l.getNombre());
            sentencia.setString(3, l.getAutor());
            sentencia.setString(4, String.valueOf(l.getPaginas()));
            sentencia.setString(5, String.valueOf(l.getPrecio()));

            int filasAfectadas = sentencia.executeUpdate();
            sentencia.close();
            conexion.close();
            if(filasAfectadas > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            return false;
        }
    }

    public static ArrayList<Comic> obtenerComics()
    {
        Connection conexion = ConfiguracionDB.conectarBaseDeDatos();
        if (conexion == null)
        {
            return null;
        }
        ArrayList<Comic> comics = new ArrayList<Comic>();

        try
        {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "SELECT * FROM comics ORDER BY ID_Comic";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while(resultado.next())
            {
                String id_comic = resultado.getString("ID_Comic");
                String nombre = resultado.getString("Nombre");
                String autor = resultado.getString("Autor");
                int num_paginas = resultado.getInt("Num_Paginas");
                Double precio = resultado.getDouble("Precio");
                Comic elComic = new Comic(id_comic, nombre, autor, num_paginas, precio);
                comics.add(elComic);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return comics;
        }
        catch (SQLException e)
        {
            Log.i("sql", "Error de SQL");
            e.printStackTrace();
            return comics;
        }
    }

}
