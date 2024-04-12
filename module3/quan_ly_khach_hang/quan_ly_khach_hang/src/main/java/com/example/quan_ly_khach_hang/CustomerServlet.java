//package com.example.quan_ly_khach_hang;
//
//import com.example.quan_ly_khach_hang.model.Customer;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name = "CustomerServlet", value = "/customer")
//public class CustomerServlet extends HttpServlet {
//    private static List<Customer> customerList=new ArrayList<>();
//    static {
//        customerList.add( new Customer(1, "John", "john@codegym.vn", "Hanoi"));
//        customerList.add( new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
//        customerList.add( new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
//        customerList.add( new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
//        customerList.add( new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
//        customerList.add( new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view//list.jsp");
//        req.setAttribute("customerList",customerList);
//        requestDispatcher.forward(req,resp);
//    }
//}
