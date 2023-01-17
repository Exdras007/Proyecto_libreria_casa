package com.example.proyecto_libreria.clases;

import java.io.Serializable;
import java.util.Objects;

public class Libro implements Serializable
{
    //Atributos
    private String ID;
    private String Nombre;
    private String Autor;
    private int paginas;
    private double precio;

    public Libro(String ID, String nombre, String autor, int paginas, double precio) {
        this.ID = ID;
        Nombre = nombre;
        Autor = autor;
        this.paginas = paginas;
        this.precio = precio;
    }

    public Libro()
    {
        this.ID = "000_000";
        Nombre = "nada";
        Autor = "nada";
        this.paginas = 0;
        this.precio = 0.0;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Libro)) return false;
        Libro libro = (Libro) o;
        return ID.equals(libro.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "ID='" + ID + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Autor='" + Autor + '\'' +
                ", paginas=" + paginas +
                ", precio=" + precio +
                '}';
    }
}
