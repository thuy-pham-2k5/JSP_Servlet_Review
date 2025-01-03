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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "view":
                showEmployeesView(req, resp);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null) action="";
        switch (action) {
            case "edit":
            case "view":
                showEmployeeInfoDetail (req, resp);
                break;
            default:
                showEmployeesView (req, resp);
                break;
        }
    }

    private void showEmployeeInfoDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("employee", employeeService.getEmployeeById(id));
        System.out.println(employeeService.getEmployeeById(id));
        req.setAttribute("action", req.getParameter("action"));
        req.getRequestDispatcher("/no_1/info_employee.jsp").forward(req, resp);
    }

    private void showEmployeesView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/no_1/home.jsp").forward(req, resp);
    }
}
