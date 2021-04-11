package datos;

import org.junit.Test;

import java.sql.*;

// clase para concectarse MySQL
public class TestMySqlJDBC {
    @Test
    public static void main(String[] args) {
        //creando variable del Url para la conxion
       var url = "jdbc:mysql://sofka-training.cpxphmd1h1ok.us-east-1.rds.amazonaws.com:3306/jacobo_diaz?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
       try {
            // creando conexion para la base de datos
           Connection connection = DriverManager.getConnection(url, "sofka_training", "BZenX643bQHw");
           //realizar la sentencias de SQL
           Statement instruccion = connection.createStatement();
           var sql = "SELECT actor_id, first_name, last_name FROM jacobo_diaz.actor";
           // realizando Query
           ResultSet resultado = instruccion.executeQuery(sql);
           while(resultado.next()){
               System.out.println("actor_id: " +resultado.getInt("actor_id"));
               System.out.print("first_name,:" +resultado.getString("first_name"));
               System.out.print("last_name:" +resultado.getString("last_name"));
               System.out.println("");
           }
            // cerrando conexion
           resultado.close();
           instruccion.close();
           connection.close();
       }catch (SQLException e){
           e.printStackTrace(System.out);

       }
    }
}
