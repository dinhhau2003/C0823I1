package com.example.demojdbc.controller;

import com.example.demojdbc.Service.UserDAO;
import com.example.demojdbc.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private UserDAO userDAO=new UserDAO();
//    private static final long serialVersionUID = 1L;
//    private UserDAO userDAO;
//
//    public void init() {
//        userDAO = new UserDAO();
//    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    insertUser(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                //
                break;
        }
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp)
              throws SQLException, IOException, ServletException {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String country = req.getParameter("country");
            User newUser=new User(name,email,country);
            userDAO.insertUser(newUser);
            RequestDispatcher dispatcher = req.getRequestDispatcher("view/create.jsp");
            dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showNewForm(req, resp);
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                listUser(req, resp);
                break;
        }
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(req, resp);
    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> listUser = userDAO.selectAllUsers();
        req.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(req, resp);
    }
}

