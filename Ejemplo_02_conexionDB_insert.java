/*
 * Clase que establece una conexión a una base de datos 
 * y ejecuta una consulta sin resultados (UPDATE, INSERT, DELETE)
 * La clase Ejemplo_01_conexionDB muestra como establecer la conexión, ahora utilizaremos 
 * un objeto de la clase Statemant para establecer sentencias y ejecutar consultas SQL.
 * 
 * Clases y métodos a destacar
 * Class.forName() -> Clase encargada de cargar el controlador en memoria
 * DriverManager.getConnection() -> Método que establece la conexión
 * Statement -> Clase para trabajar con sentencias sobre una BBDD
 * createStatement -> Método de la clase Statement que crea el statement (sentencia)
 * exectue() -> Método de la clase Statement que lanzará las cnosultas SQL
 * 
 * Excepciones:
 * ClassNotFoundException -> Lanzada por la clase 'Class"
 * SQLException -> Lanzada por las clases Connection y Statement
 */
package Java_derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo_02_conexionDB_insert {
    //Controlador y URL de la BBDD
    static final String DRIVER = ("org.apache.derby.jdbc.EmbeddedDriver"); 
    static final String URL = ("jdbc:derby://localhost:1527/ejemploDB;create=true");
    
    public static void main(String[] args){
        //Objeto Connection para establecer la conexión
        Connection cn = null;
        //Objeto Statement para crear sentencias y realizar consultas SQL sobre la BBDD
        Statement st = null;
        
        try{
            //Carga del controlador en memoria
            Class.forName(DRIVER);                 
            //Establece conexion
            cn = DriverManager.getConnection(URL);  
            //Crear objeto Statemennt(sentencia) para enviar consultas a la BBDD.
            st = cn.createStatement();          
            //Ejecutar sentencias SQL
            //El método 'execute' de la clase Statemant solo permite realizar consultas SQL
            //sin resultados, como pueden ser INSERT, UPDATE, DELETE.
            st.execute("INSERT INTO MUESTRA(ID, CLIENTE) "
                    + "VALUES (487,'Felipe Almeida'),(443, 'Eusebio Sanchez'), (9874, 'Eduardo Vazquez')");
            System.out.println("Registros añadidos en la BBDD");
            //Cierre del Statement(sentencia)
            st.close();
            //Cierre de la cnexion
            cn.close();
        }
        catch(ClassNotFoundException ex){ System.out.println(ex.getMessage()); }
        catch(SQLException ex){ System.out.println(ex.getMessage()); }
    } //Fin main
} //Fin clase