/*
 * Esta clase muestra de forma sencilla como establecer una conexión a
 * una base de datos y ejecutar una consulta sin resultados (UPDATE, INSERT, DELETE)
 * Utilizando clases o interfaces que forman parte del API JDBC
 * se puede realizar esta operación, estas son:
 * 
 * 1 - Class.forName("com.mysql.jdbc.Driver"); Cargar el driver en memoria antes de establecer la conexión
 * 
 * 2 - DriverManager: (Clase) Establece la conexión a través del driver que se le pasa 
 * como parámetro a su método 'getConnection'
 * 
 * 3 - Connection: (Interfaz) Cualquier conexión realizada a la base de datos implementan esta interfaz
 * Toda transferencia de datos se realiza a través de un objeto Connection
 * 
 * 4 - Statement: (Interfaz) Esta interfaz nos proporciona los métodos necesarios para ejecutar
 * consultas en la base de datos
 * 
 */
package Ejemplo_01_Java_derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Ejemplo_02_conexionDB {
    static final String DRIVER = ("org.apache.derby.jdbc.EmbeddedDriver"); 
    static final String URL = ("jdbc:derby://localhost:1527/ejemploDB;create=true");
    
    public static void main(String[] args){
    
        Connection cn = null;
        Statement st = null;
        
        try{
            
            Class.forName(DRIVER);                  //Carga del controlador en memoria
            cn = DriverManager.getConnection( URL); //Objeto Connection con el valor del método 'getConnection' de la clase 'DriveManager'
            st = cn.createStatement();              //Crear objeto Statemennt(sentencia) para enviar consultas a la BBDD.
            st.execute("INSERT INTO MUESTRA(ID, CLIENTE) "
                    + "VALUES (487,'Felipe Almeida')");//Ejecutar consultas con el método 'execute()'
           
            
            //Cierre del Statement(sentencia)
            st.close();
            //Cierre de la cnexion
            cn.close();
            
            System.out.println("Datos añadidos en la BBDD");
            
        }
        catch(Exception e){ System.out.println(e.getMessage());}
    } //Fin main
} //Fin clase
