package com.example.jsp_servlet_review.no_1.service;

import com.example.jsp_servlet_review.no_1.database.ConnectDatabase;
import com.example.jsp_servlet_review.no_1.model.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    @Override
    public List<Department> getAllDepartment() {
        String query = "select * from departments";
        List<Department> departments = new ArrayList<>();
        try (Connection connection = ConnectDatabase.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                departments.add(new Department(id, name));
            }
            return departments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
