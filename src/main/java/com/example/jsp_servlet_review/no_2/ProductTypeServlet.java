package com.example.jsp_servlet_review.no_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/product-type")
public class ProductTypeServlet extends HttpServlet {
    ProductTypeService productTypeService = new ProductTypeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action==null) action="";
        switch (action) {
            case "add":
                addNewProductInDatabase (req, resp);
                break;
            default:
                break;
        }
    }

    private void addNewProductInDatabase(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int id_type = Integer.parseInt(req.getParameter("id_type"));
        productTypeService.addNewProductType(name, price, quantity, id_type);

        req.setAttribute("products", productTypeService.getAllProduct(false));
        req.getRequestDispatcher("/no_2/view/home.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");
        if (action==null) action="";
        switch (action) {
            case "add":
                showAddNewProductLayout (req, resp);
                break;
            default:
                showListProduct (req, resp);
                break;
        }
    }

    private void showAddNewProductLayout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("types", productTypeService.getAllType());
        req.getRequestDispatcher("/no_2/view/add_new_product.jsp").forward(req, resp);
    }

    private void showListProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productTypeService.getAllProduct(true));
        req.getRequestDispatcher("/no_2/view/home.jsp").forward(req, resp);
    }
}
