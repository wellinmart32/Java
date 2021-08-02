package filewriterdatabasetable;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author welli
 */
public class DbConnector {
    private String url, user, pass;
    private Connection conn;
    
    public DbConnector() {
        this.url = "jdbc:mysql://localhost:3306/indrfloresdb";
        this.user = "root";
        this.pass = "";
        conn = null;
    }
    
    public Connection startConnection() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión con la base de datos exitosa");
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos");
        }
        return conn;
    }
}
