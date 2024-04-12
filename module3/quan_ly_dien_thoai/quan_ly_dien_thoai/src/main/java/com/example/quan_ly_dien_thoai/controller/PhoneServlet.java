package com.example.quan_ly_dien_thoai.controller;

import com.example.quan_ly_dien_thoai.model.Phone;
import com.example.quan_ly_dien_thoai.service.PhoneServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhoneServlet",value = "/phone")
public class PhoneServlet extends HttpServlet {
    PhoneServiceImpl phoneService=new PhoneServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case"create":
                showCreate(req,resp);
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                showList(req,resp);
                break;
        }
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("view/create.jsp");
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Phone> phoneList =phoneService.findAll();
        System.out.println(phoneList.size());
        req.setAttribute("phoneList",phoneList);
        req.getRequestDispatcher("view/list.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action){
            case "create":
                create(request,response);
                break;
            case "update":
//                update(request,response);
                break;
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
