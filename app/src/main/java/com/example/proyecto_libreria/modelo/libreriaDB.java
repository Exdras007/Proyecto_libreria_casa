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

    public static ArrayList<String> obtenerAutores()
    {
        Connection conexion = ConfiguracionDB.conectarBaseDeDatos();
        if (conexion == null)
        {
            return null;
        }

        ArrayList<String> Autores = new ArrayList<String>();
        String Todos = "Todos";
        Autores.add(Todos);
        try
        {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "SELECT DISTINCT Autor FROM libreria.libros";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);

            while(resultado.next())
            {
                String Autor = resultado.getString("Autor");
                Autores.add(Autor);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return Autores;
    }

    public static ArrayList<String> obtenerAutoresC()
    {
        Connection conexion = ConfiguracionDB.conectarBaseDeDatos();
        if (conexion == null)
        {
            return null;
        }

        ArrayList<String> Autores = new ArrayList<String>();
        String Todos = "Todos";
        Autores.add(Todos);
        try
        {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "SELECT DISTINCT Autor FROM libreria.comics";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);

            while(resultado.next())
            {
                String Autor = resultado.getString("Autor");
                Autores.add(Autor);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return Autores;
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

    public static boolean borrarLibro(String ID_Libro)
    {
        Connection conexion = ConfiguracionDB.conectarBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try
        {
            String ordensql = "DELETE FROM libros WHERE (ID_Libro = ?);";
            PreparedStatement sentencia = conexion.prepareStatement(ordensql);
            sentencia.setString(1, ID_Libro);
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

    public static boolean actualizarLibro(Libro l, String cod_libroAntiguo)
    {
        Connection conexion = ConfiguracionDB.conectarBaseDeDatos();
        if(conexion == null)
        {
            return false;
        }
        try
        {
            String ordensql = "UPDATE libros SET ID_Libro = ?, Nombre = ?, Autor = ?, Num_Paginas = ?, Precio = ? WHERE ID_Libro = ?";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, l.getID());
            pst.setString(2, l.getNombre());
            pst.setString(3, l.getAutor());
            pst.setString(4, String.valueOf(l.getPaginas()));
            pst.setString(5, String.valueOf(l.getPrecio()));
            int filasAfectadas = pst.executeUpdate();
            pst.close();
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
            e.printStackTrace();
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

    public static ArrayList<Libro> filtrarPorAutor(String autorFiltrar)
    {
        Connection conexion = ConfiguracionDB.conectarBaseDeDatos();
        if (conexion == null)
        {
            return null;
        }
        ArrayList<Libro> librosDevueltos = new ArrayList<Libro>();

        try
        {
            String ordenSQL = "";
            PreparedStatement pst = null;
            if(autorFiltrar.equalsIgnoreCase("Todos"))
            {
                ordenSQL = "SELECT * FROM libros ORDER BY ID_Libro";
                pst = conexion.prepareStatement(ordenSQL);
            }
            else
            {
                ordenSQL = "SELECT * FROM libros WHERE Autor like ?";
                pst = conexion.prepareStatement(ordenSQL);
                pst.setString(1, autorFiltrar);
            }
            ResultSet resultado = pst.executeQuery();
            while(resultado.next())
            {
                String id_libro = resultado.getString("ID_Libro");
                String nombre = resultado.getString("Nombre");
                String autor = resultado.getString("Autor");
                int num_paginas = resultado.getInt("Num_Paginas");
                Double precio = resultado.getDouble("Precio");
                Libro elLibro = new Libro(id_libro, nombre, autor, num_paginas, precio);
                librosDevueltos.add(elLibro);
            }
            resultado.close();
            pst.close();
            conexion.close();

            return librosDevueltos;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return librosDevueltos;
        }
    }

    public static ArrayList<Comic> filtrarPorAutorC(String autorFiltrarC)
    {
        Connection conexion = ConfiguracionDB.conectarBaseDeDatos();
        if (conexion == null)
        {
            return null;
        }
        ArrayList<Comic> comicsDevueltos = new ArrayList<Comic>();

        try
        {
            String ordenSQL = "";
            PreparedStatement pst = null;
            if(autorFiltrarC.equalsIgnoreCase("Todos"))
            {
                ordenSQL = "SELECT * FROM comics ORDER BY ID_Comic";
                pst = conexion.prepareStatement(ordenSQL);
            }
            else
            {
                ordenSQL = "SELECT * FROM comics WHERE Autor like ?";
                pst = conexion.prepareStatement(ordenSQL);
                pst.setString(1, autorFiltrarC);
            }
            ResultSet resultado = pst.executeQuery();
            while(resultado.next())
            {
                String id_comic = resultado.getString("ID_Comic");
                String nombre = resultado.getString("Nombre");
                String autor = resultado.getString("Autor");
                int num_paginas = resultado.getInt("Num_Paginas");
                Double precio = resultado.getDouble("Precio");
                Comic elComic = new Comic(id_comic, nombre, autor, num_paginas, precio);
                comicsDevueltos.add(elComic);
            }
            resultado.close();
            pst.close();
            conexion.close();

            return comicsDevueltos;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return comicsDevueltos;
        }
    }
}
