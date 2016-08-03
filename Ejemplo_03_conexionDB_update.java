/*
 * Esta clase es practicamente igual a la clase Ejemplo_02_conexionDB, con la
 * diferencia que la consulta será de actualización de registros (UPDATE)
 * Excepciones:
 * ClassNotFoundException -> Lanzada por la clase 'Class"
 * SQLException -> Lanzada por las clases Connection y Statement
 */
package Java_derby;

import static Java_derby.Ejemplo_02_conexionDB_insert.DRIVER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo_03_conexionDB_update {
    
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
            cn = DriverManager.getConnection( URL);  
            //Crear objeto Statemennt(sentencia) para enviar consultas a la BBDD.
            st = cn.createStatement();          
            //Ejecutar sentencias SQL
            //El método 'execute' de la clase Statemant solo permite realizar consultas SQL
            //sin resultados, como pueden ser INSERT, UPDATE, DELETE.
            st.execute("UPDATE MUESTRA "
                     + "SET ID=258, CLIENTE='Gonzalo de la Parra' "
                     + "WHERE ID=25");
            
            System.out.println("Registro actualizado en la BBDD");
            
            //Cierre del Statement(sentencia)
            st.close();
            //Cierre de la cnexion
            cn.close();
        }
        catch(ClassNotFoundException ex){ System.out.println(ex.getMessage()); }
        catch(SQLException ex){ System.out.println(ex.getMessage()); }
    }
    
}
