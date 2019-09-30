/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Conexion {
    private static Connection conn;
    public  static final String URL = "jdbc:mysql://localhost:3306/gruas?useTimezone=true&serverTimezone=UTC";
    public  static final String USERNAME = "root";
    public  static final String PASSWORD = "123456";
    
    public Conexion(){
        conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Conexion exitosa");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  Connection getConection(){
        return conn;
    }
    
    public void desconectar(){
        conn = null;
        if(conn == null){
            System.out.println("Conexion terminada...");
        }
        
    }
    
}
