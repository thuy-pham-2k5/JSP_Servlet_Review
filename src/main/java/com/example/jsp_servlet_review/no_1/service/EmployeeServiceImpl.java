package com.example.jsp_servlet_review.no_1.service;

import com.example.jsp_servlet_review.no_1.database.ConnectDatabase;
import com.example.jsp_servlet_review.no_1.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

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

    @Override
    public Employee getEmployeeById(int idEmployee) {
        String query = "{call getEmployeeById (?)}";
        try (Connection connection = ConnectDatabase.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, idEmployee);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString(2);
                String department = resultSet.getString(3);
                String position = resultSet.getString(4);
                double salary = resultSet.getDouble(5);
                String address = resultSet.getString(6);
                return new Employee(idEmployee, name, department, position, salary, address);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewEmployee(String name, int idDepartment, String position, double salary, String address) {
        String query = "INSERT INTO employees (name, position, salary, address, id_department) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, position);
            preparedStatement.setDouble(3, salary);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, idDepartment);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateInfoEmployee(int idEmployee, String name, String position, Double salary, String address, int idDepartment) {
        String query = "{call updateInfoEmployee (?, ?, ?, ?, ?, ?)}";
        try (Connection connection = ConnectDatabase.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, idEmployee);
            callableStatement.setString(2, name);
            callableStatement.setString(3, position);
            callableStatement.setDouble(4, salary);
            callableStatement.setString(5, address);
            callableStatement.setInt(6, idDepartment);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployee(int idEmployee) {
        String query = "delete from employees where id_employee = ?";
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idEmployee);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> searchEmployeeByName(String keyword) {
        List<Employee> employees = new ArrayList<>();
        String query = "{call searchEmployeeByName (?)}";
        try (Connection connection = ConnectDatabase.getConnection()) {
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, keyword);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                int idEmployee = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String department = resultSet.getString(3);
                String position = resultSet.getString(4);
                double salary = resultSet.getDouble(5);
                String address = resultSet.getString(6);
                employees.add(new Employee(idEmployee, name, department, position, salary, address));
            }
            return employees;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
