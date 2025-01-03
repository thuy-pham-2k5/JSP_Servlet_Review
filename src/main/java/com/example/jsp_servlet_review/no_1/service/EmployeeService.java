package com.example.jsp_servlet_review.no_1.service;

import com.example.jsp_servlet_review.no_1.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees ();
    Employee getEmployeeById (int idEmployee);
}
