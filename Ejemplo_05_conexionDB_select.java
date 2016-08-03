/**
 * Clase que establece una conexión a una base de datos 
 * y ejecuta una consulta sql de selección que devuelve una tabla
 * 
 * En las consultas que no devuelven resultado (INSERT, DELETE, UPDATE) utilizamos
 * el método 'execute' de la clase Statement. Pero en este caso si devuelve datos
 * por lo que debemos crear un objeto ResultSet que permite trabajar con los resultados
 * 
 * Clases y métodos a destacar
 * Class.forName() -> Clase encargada de cargar el controlador en memoria
 * Connection -> Un objeto Cnnnection administra la conexión entre la aplicación y la BBDD
 * DriverManager.getConnection() -> Método que establece la conexión
 * Statement -> Clase para trabajar con sentencias sobre una BBDD
 * createStatement() -> Método de la clase Statement que crea el statement (sentencia)
 * executeQuery() -> Método de la clase Statement que lanzará las cnosultas SQL
 * ResultSet -> Clase que proporciona métodos para trabajar con los resultados de la consulta sql que devuelve el Statement
 * next() -> Mñetodo de la clase ResultSet que permte avanzar por los registros obtenidos como resultado
 * 
 * Excepciones:
 * ClassNotFoundException -> Lanzada por la clase 'Class"
 * SQLException -> Lanzada por las clases Connection y Statement
 */
package Java_derby;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejemplo_05_conexionDB_select {
    
    static final String DRIVER = ("org.apache.derby.jdbc.EmbeddedDriver"); 
    static final String URL = ("jdbc:derby://localhost:1527/ejemploDB;create=true");

    public static void main(String[] args){
        
        Connection cn = null;   //Administra la conexión
        Statement st = null;    //Crear sentencias y ejecutarlas
        ResultSet rs = null;    //Trabajar con los resultados
        
        try{
            Class.forName(DRIVER);
            cn = DriverManager.getConnection(URL);
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM MUESTRA");
            //Recorrer la tabla obtenida como resultado
            while( rs.next()){
                System.out.println( rs.getInt("ID") + "\t" + rs.getString("CLIENTE"));
            }
            //Cierre del objeto ResultSet
            rs.close();
            //Cierre del objeto Statement
            st.close();
            //Cierre de la conexion
            cn.close();
        }
         catch(ClassNotFoundException ex){ System.out.println(ex.getMessage()); }
         catch(SQLException ex){ System.out.println(ex.getMessage()); }
    } //Fin main
} //Fin clase
