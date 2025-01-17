package com.example.jsp_servlet_review.no_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
    public static Connection getConnection() throws SQLException {
        final String username = "root";
        final String password = "1234";
        final String urlJDBC = "jdbc:mysql://127.0.0.1:3306/jsp_servlet_review";
        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(urlJDBC, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        getConnection();
    }
}
