
package Ejemplo_01_Java_derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejemplo_01_conexionDB {
    
   static final String DRIVER = ("org.apache.derby.jdbc.EmbeddedDriver"); 
   static final String URL = ("jdbc:derby://localhost:1527/ejemploDB;create=true");
   
   public static void main(String[] args){
       
       Connection cn = null;    //Clase Connection para manejar la conexión cnn la DDBB
       Statement st = null;     //Clase statement para manejar las sentencias de consulta
       ResultSet rs = null;     //ResultSet para menejar los resultados
       
       //Conectar con la DDBB y realizar consulta
       try{
           //Carga del driver
           Class.forName(DRIVER);
           //Establece la conexión cn la DDBB
           cn = DriverManager.getConnection(URL);
           //Objeto Statement para manejar las instrucciones con la DDBB
           st = cn.createStatement();
           //Lanzar consulta y obtener resultado a través de un objeto ResultSet
           rs = st.executeQuery("SELECT * FROM MUESTRA");
           //Muestra el resultado
           while (rs.next()){
               System.out.println("ID = " + rs.getString("ID") + " *** CLIENTE = " + rs.getString("CLIENTE"));
           }
           
           //Cierre del statement
           st.close();
           //Cierre de la conexion
           cn.close();
       }
       
       catch(ClassNotFoundException ex){ System.out.println(ex.getMessage()); }
       catch(SQLException ex){ System.out.println(ex.getMessage()); }
    
   }//Fin main
     
} //Fin clase

/*
    En 4 pasos:
    1 - Cargar el Controlador para Java DB 
    3 - Establecer la conexion a través de un objeto Connection
    3 - Crear objeto Statement a través del cual se realizarán las consultas
    4 - Objeto ResultSet para obtener resultado de la consulta
*/