package com.example.thi_dto.controller;

import com.example.thi_dto.dto.ProductDto;
import com.example.thi_dto.model.Category;
import com.example.thi_dto.model.Product;
import com.example.thi_dto.service.CategoryServiceImpl;
import com.example.thi_dto.service.ICategoryService;
import com.example.thi_dto.service.IProductService;
import com.example.thi_dto.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet",value = "/product")
public class ProductServlet extends HttpServlet {
    IProductService productService=new ProductServiceImpl();
    ICategoryService categoryService=new CategoryServiceImpl();
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
//                search(req,resp);
                break;
            case "update":
//                showUpdate(req, resp);
                break;
            case "delete":
//                delete(req,resp);
                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.findAllCategory();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/product/create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categories = categoryService.findAllCategory();
        req.setAttribute("categories", categories);
        List<ProductDto> products = productService.findAllDto();
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
//                update(req, resp);
                break;
        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Float gia= Float.valueOf(req.getParameter("gia"));
        String soLuong=req.getParameter("soLuong");
        String color=req.getParameter("color");
        String moTa=req.getParameter("moTa");
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        Product product = new Product(name,gia,soLuong,color,moTa,idCategory);
        productService.addProduct(product);
        showList(req, resp);
    }

}
