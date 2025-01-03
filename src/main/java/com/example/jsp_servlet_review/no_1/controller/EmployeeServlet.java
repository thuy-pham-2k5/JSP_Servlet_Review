package com.example.jsp_servlet_review.no_1.controller;

import com.example.jsp_servlet_review.no_1.model.Employee;
import com.example.jsp_servlet_review.no_1.service.EmployeeService;
import com.example.jsp_servlet_review.no_1.service.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (value = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null) action="";
        switch (action) {
            default:
                showEmployeesView (req, resp);
                break;
        }
    }

    private void showEmployeesView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("no_1/home.jsp").forward(req, resp);
    }
}
