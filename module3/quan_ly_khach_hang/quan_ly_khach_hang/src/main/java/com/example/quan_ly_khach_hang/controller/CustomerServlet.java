package com.example.quan_ly_khach_hang.controller;

import com.example.quan_ly_khach_hang.model.Customer;
import com.example.quan_ly_khach_hang.service.CustomerService;
import com.example.quan_ly_khach_hang.service.ICustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService=new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action ="";
        }
        switch (action){
            case "add":
                showAddForm(req,resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
            default:
                showList(req,resp);

        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        } else {
            req.setAttribute("customer", customer);
            dispatcher = req.getRequestDispatcher("view/customer/delete.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/customer/list.jsp");
        List<Customer>customerList=customerService.findAll();
        req.setAttribute("customerList",customerList);
        requestDispatcher.forward(req,resp);
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher1 = req.getRequestDispatcher("view/customer/add.jsp");
//        requestDispatcher1.forward(req,resp);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/customer/add.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action ="";
        }
        switch (action){
            case "add":
                save(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
            default:
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int id =Integer.parseInt(req.getParameter("id"));
        Customer customer=this.customerService.findById(id);
        RequestDispatcher dispatcher;
        if (customer==null){
            dispatcher=req.getRequestDispatcher("error-404.jsp");
        }else {
            this.customerService.remove(id);
            try {
                resp.sendRedirect("/customer");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        Customer customer=new Customer(id,name,email,address);
        boolean check = customerService.add(customer);
        String mess = "Not Ok";
        if (check){
            mess ="OK";
        }
        resp.sendRedirect("/customer?mess="+mess);
    }

}
