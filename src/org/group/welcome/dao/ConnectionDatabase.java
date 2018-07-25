package org.group.welcome.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDatabase {
    public static String DRIVER = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://127.0.0.1:3306/welcome";
    public static  String USER = "root";
    public static String PASSWORD = "431241wjw";
    public Connection conn;
    public ConnectionDatabase(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConnnection(){
        return conn;
    }
}
