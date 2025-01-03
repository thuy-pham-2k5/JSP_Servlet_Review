package com.example.jsp_servlet_review.no_1.service;

import com.example.jsp_servlet_review.no_1.database.ConnectDatabase;
import com.example.jsp_servlet_review.no_1.model.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "{call getAllEmployees()}";
        try (Connection connection = ConnectDatabase.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String department = resultSet.getString(3);
                String position = resultSet.getString(4);
                double salary = resultSet.getDouble(5);
                String address = resultSet.getString(6);
                employees.add(new Employee(id, name, department, position, salary, address));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
