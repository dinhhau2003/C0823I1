package com.example.productti.controller;

import com.example.productti.model.Category;
import com.example.productti.model.Product;
import com.example.productti.service.impl.CategoryServiceImpl;
import com.example.productti.service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    CategoryServiceImpl categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(req, resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            case "search":
                search(req,resp);
                break;
            case "update":
                showUpdate(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.findAllCategory();
        req.setAttribute("categories", categories);
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("product", product);
        req.getRequestDispatcher("/product/update.jsp").forward(req, resp);
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        List<Product> productList =productService.search(name);
        req.setAttribute("products", productList);
        req.getRequestDispatcher("/product/list.jsp").forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.deleteProduct(id);
        showList(req,resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.findAllCategory();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/product/create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAllProduct();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/product/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Date day = Date.valueOf(req.getParameter("day"));
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        Product product = new Product(id, name, day, idCategory);
        productService.updateProduct(product);
        showList(req, resp);
    }


    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Date day = Date.valueOf(req.getParameter("day"));
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        Product product = new Product(name, day, idCategory);
        productService.addProduct(product);
        showList(req, resp);
    }
}
