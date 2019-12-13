/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.gruasService.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author henry
 */
public class DBConnect {

    String bd = "gruas";
    String url = "jdbc:mysql://35.202.170.59:3306/" + bd;
    //String url = "jdbc:mysql://dbexam.cfgcmgabp2dx.us-east-1.rds.amazonaws.com:3306/"+ bd;
    String user = "root";
    String pass = "qwer1234";
    Connection connection = null;

    public DBConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);

            if (connection != null) {
                System.out.println("Successful connection");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR" + ex.getMessage());
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void finished() {
        connection = null;
        if (connection == null) {
            System.out.println("Connection finished...");
        }
    }

}
