package com.dictionary.data.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private String url = "jdbc:mysql://localhost:3306/entries?useSSL=false";
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String username = "root";
    private String password = "1F2becd9";
    private java.sql.Connection con;

    public DbConnection() {}

    public Connection getConnection() {
        try
        {
            Class.forName(driverName);
            try
            {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex)
            {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex)
        {
            // log an exception. for example:
            System.out.println("Driver not found.");
        }
        return con;
    }
}
