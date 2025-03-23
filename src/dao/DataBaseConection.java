
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConection {
    final String URL = "jdbc:mysql://localhost:3306/empresa";
    final String USER = "root";
    final String PASSWORD = "";
    Connection conn;
    public Connection getConection(){
        try{
            
            return conn = DriverManager.getConnection(URL,USER,PASSWORD);
            
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Erro ao se conectar ao banco");
            return null;
        }
    }
}
