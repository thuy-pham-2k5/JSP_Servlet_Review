package com.example.jsp_servlet_review.no_1.service;

import com.example.jsp_servlet_review.no_1.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees ();
    Employee getEmployeeById (int idEmployee);
    void addNewEmployee (String name, int idDepartment, String position, double salary, String address);
    void updateInfoEmployee (int idEmployee, String name, String position, Double salary, String address, int idDepartment);
    void deleteEmployee (int idEmployee);
    List<Employee> searchEmployeeByName (String keyword);
}
