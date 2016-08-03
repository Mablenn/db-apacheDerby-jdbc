/*
 * Este es un sencillo ejemplo para establecer una conexión con una base de datos
 * a través de la API JDBC. Una vez creada la base de datos necesitamos saber cual
 * es el controlador y la URL de de esta.
 * 
 * Controlador -> "org.apache.derby.jdbc.EmbeddedDriver"
 * URL -> "jdbc:derby://localhost:1527/ejemploDB;create=true"
 * La forma para conectarse consiste en cargar el controlador en memoria a través del
 * método 'forName¡ de la clase 'Class' y a continuación establecer la conexión mediante 
 * un objeto de la clase Connection
 * 
 * Excepciones:
 * ClassNotFoundException -> Lanzada por el método 'forName' de la clase 'Class"
 * SQLException -> Lanzada por la clase Connection
 * 
 */

package Java_derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo_01_conexionDB {
    
   static final String DRIVER = ("org.apache.derby.jdbc.EmbeddedDriver"); 
   static final String URL = ("jdbc:derby://localhost:1527/ejemploDB;create=true");
   
   public static void main(String[] args){
       
       Connection cn = null;    //Clase Connection para manejar la conexión cnn la DDBB
       //Conectar con la DDBB
       try{
           //Carga del driver
           Class.forName(DRIVER);
           //Establece la conexión cn la DDBB
           cn = DriverManager.getConnection(URL);
           System.out.println("Conexion establecida con la bases de datos");
           
           //Cierre de la conexion
           cn.close();
       }
       catch(ClassNotFoundException ex){ System.out.println(ex.getMessage()); }
       catch(SQLException ex){ System.out.println(ex.getMessage()); }
    
   }//Fin main
} //Fin clase

