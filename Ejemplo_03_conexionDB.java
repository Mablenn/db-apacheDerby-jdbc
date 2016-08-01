/*
    Esta clase realiza una conexión con una base de datos a través del driver Derby
    Utiliza las clases más básicas para conectar y realizar consultas
    Class.forName(DRIVER) -> Cargar controlador en memoria
    Connection cn = DriverManager.getConnecton(URL) -> Establecer la conexión
    Statement st -> Crear objeto Statement para realizar sentencis SQL
    ResultSet rs -> Objeto para trabajar con los resultados de la consulta

    Además utilizará un objeto de la clase ResultSetMetaData para trabajar
    con los metadatos de la BBDD.
*/
package Ejemplo_01_Java_derby;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
      

public class Ejemplo_03_conexionDB {
    static final String DRIVER = ("org.apache.derby.jdbc.EmbeddedDriver"); 
    static final String URL = ("jdbc:derby://localhost:1527/ejemploDB;create=true");

    public static void main(String[] args){
        
        Connection conexion = null;
        Statement instruccion = null;
        ResultSet conjuntoResultados = null;
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            instruccion = conexion.createStatement();
            conjuntoResultados = instruccion.executeQuery("SELECT * FROM MUESTRA");
            
            //Obtención de metadatos a través de un objeto de la clase ResultSetMetadata
            ResultSetMetaData metaDatos = conjuntoResultados.getMetaData();
            int numeroColumnas = metaDatos.getColumnCount();
            System.out.println("Tabla Muestra de la BBDD ejemploDB");

            for (int i = 1; i <= numeroColumnas; i++) {
                System.out.println("Nombre de la columna: " + i + " " + metaDatos.getColumnName(i));
            }
            
            System.out.println();
            while( conjuntoResultados.next()){
                for (int i = 1; i <= numeroColumnas; i++) {
                    System.out.println( "Objeto " + i + " " + conjuntoResultados.getObject(i));
                }
            }
        
            conjuntoResultados.close();
            instruccion.close();
            conexion.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    } //Fin main
} //Fin clase
