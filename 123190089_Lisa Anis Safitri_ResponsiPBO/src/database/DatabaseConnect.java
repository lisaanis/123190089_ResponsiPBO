package database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {
    String dbUrl = "jdbc:mysql://localhost/barang";
    //String url = "jdbc:mysql://localhost:3306/barang?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String dbUsername = "root";
    String dbPassword = "";
    private Connection connection;
    
    public DatabaseConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            System.out.println("Koneksi berhasil");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Koneksi gagal");
        }
    }

    public Connection getConnection(){
        return  connection;
    }
}