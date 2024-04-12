package com.example.on_tap.controller;

import com.example.on_tap.model.Category;
import com.example.on_tap.model.Product;
import com.example.on_tap.service.CategoryService;
import com.example.on_tap.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();

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
            case "search":
                search(req, resp);
                break;
            case "update":
                showUpdate(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.findAllCategory();
        req.setAttribute("categories", categories);
        String tenCategory = req.getParameter("tenCategory");
        String name = req.getParameter("name");
        List<Product> products =productService.search(tenCategory, name);
        req.setAttribute("products", products);
        req.getRequestDispatcher("/product/list.jsp").forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idDelete"));
        productService.delete(id);
        showList(req, resp);
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories=categoryService.findAllCategory();
        req.setAttribute("categories",categories);
        int id = Integer.parseInt(req.getParameter("idUpdate"));
        Product product =productService.findById(id);
        req.setAttribute("product",product);
        req.getRequestDispatcher("/product/update.jsp").forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories=categoryService.findAllCategory();
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/product/create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories=categoryService.findAllCategory();
        req.setAttribute("categories",categories);
        List<Product> products=productService.findAllProduct();
        req.setAttribute("products",products);
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
        int idProduct=Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Date day = Date.valueOf(req.getParameter("day"));
        Boolean gender = Boolean.valueOf(req.getParameter("gender"));
        int id = Integer.parseInt(req.getParameter("ma"));
        Product product=new Product(idProduct,name,gender,day,id);
        productService.update(product);
        showList(req,resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        Date day = Date.valueOf(req.getParameter("day"));
        Boolean gender = Boolean.valueOf(req.getParameter("gender"));
        int id = Integer.parseInt(req.getParameter("ma"));
        Product product=new Product(name,gender,day,id);
        productService.addProduct(product);
        showList(req, resp);
    }
}
