package com.example.proyecto_libreria.modelo;

import android.os.StrictMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracionDB
{
    public static final String hostDB = "10.0.2.2"; // Si el host es local se pone 10.0.2.2
    public static final String nombreDB = "libreria"; // Nombre de la base de datos
    public static final String usuarioDB = "root";
    public static final String claveDB = "485163002";
    public static final String opcionHORA = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    // las opciones de hora tambien las puedes poner en mysql, si no da error de vez en cuando
    // SET GLOBAL time_zone = '+1:00';
    public static final String puertoMYSQL = "3306"; // Aqui pongo el puerto
    public static final String urlMYSQL = "jdbc:mysql://"+ hostDB +":"+puertoMYSQL + "/" + nombreDB + opcionHORA;

    // --------------------------------------------------------------------------------------------------------------

    public static Connection conectarBaseDeDatos()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try
        {
            Connection conexion = DriverManager.getConnection(urlMYSQL, usuarioDB, claveDB);
            return conexion;
        }
        catch (SQLException e)
        {e.printStackTrace();
            System.out.println("No se pudo establecer la conexion con la base de datos");
            return null;
        }
    }

}
