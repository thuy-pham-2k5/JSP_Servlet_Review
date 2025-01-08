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

@WebServlet(value = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                addNewEmployee(req, resp);
                break;
            case "edit":
                updateInfoEmployee(req, resp);
                break;
            case "view":
                showEmployeesView(req, resp);
                break;
            case "search":
                searchEmployeeByName(req, resp);
                break;
            default:
                break;
        }
    }

    private void searchEmployeeByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        req.setAttribute("employees", employeeService.searchEmployeeByName(keyword));
        req.getRequestDispatcher("/view/no_1/home.jsp").forward(req, resp);
    }

    private void addNewEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        int idDepartment = Integer.parseInt(req.getParameter("department"));
        String position = req.getParameter("position");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String address = req.getParameter("address");
        employeeService.addNewEmployee(name, idDepartment, position, salary, address);
        resp.sendRedirect("/employees");
    }

    private void updateInfoEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int idDepartment = Integer.parseInt(req.getParameter("department"));
        String position = req.getParameter("position");
        Double salary = Double.parseDouble(req.getParameter("salary"));
        String address = req.getParameter("address");
        employeeService.updateInfoEmployee(id, name, position, salary, address, idDepartment);
        resp.sendRedirect("/employees");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                showAddNewEmployee(req, resp);
                break;
            case "edit":
            case "view":
                showEmployeeInfoDetail(req, resp);
                break;
            case "delete":
                deleteInfoEmployee(req, resp);
                break;
            default:
                showEmployeesView(req, resp);
                break;
        }
    }

    private void deleteInfoEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        employeeService.deleteEmployee(id);
        resp.sendRedirect("employees");
    }

    private void showAddNewEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/view/no_1/add_new_employee.jsp");
    }

    private void showEmployeeInfoDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("employee", employeeService.getEmployeeById(id));
        req.setAttribute("action", req.getParameter("action"));
        req.getRequestDispatcher("/view/no_1/info_employee.jsp").forward(req, resp);
    }

    private void showEmployeesView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAllEmployees();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("view/no_1/home.jsp").forward(req, resp);
    }
}
