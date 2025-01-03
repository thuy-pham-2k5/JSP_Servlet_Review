package com.example.jsp_servlet_review.no_1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String username = "root";
            String password = "1234";
            String urlJDBC = "jdbc:mysql://localhost:3306/jsp_servlet_review";
            connection = DriverManager.getConnection(urlJDBC, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("successfully");
        return connection;
    }
}
