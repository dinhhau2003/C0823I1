package com.example.quanlyphongtro.controller;

import com.example.quanlyphongtro.model.Pay;
import com.example.quanlyphongtro.model.Room;
import com.example.quanlyphongtro.service.PayServiceImpl;
import com.example.quanlyphongtro.service.RoomServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "RoomServlet", value = "/room")
public class RoomServlet extends HttpServlet {
    RoomServiceImpl roomService = new RoomServiceImpl();
    PayServiceImpl payService = new PayServiceImpl();

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
                    search(req,resp);
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
        List<Pay> pays = payService.findAllPay();
        req.setAttribute("pays", pays);
        String tenThanhToan = req.getParameter("tenThanhToan");
        String name = req.getParameter("name");
        List<Room> rooms =roomService.search(tenThanhToan, name);
        req.setAttribute("rooms", rooms);
        req.getRequestDispatcher("/room/list.jsp").forward(req,resp);
    }


    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pay> pays = payService.findAllPay();
        req.setAttribute("pays", pays);
        int id = Integer.parseInt(req.getParameter("id"));
        Room room =roomService.findById(id);
        req.setAttribute("room", room);
        req.getRequestDispatcher("/room/update.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        roomService.deleteRoom(id);
        showList(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pay> pays = payService.findAllPay();
        req.setAttribute("pays", pays);
        req.getRequestDispatcher("/room/create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pay> pays = payService.findAllPay();
        req.setAttribute("pays", pays);
        List<Room> rooms = roomService.findAllRoom();
        req.setAttribute("rooms", rooms);
        req.getRequestDispatcher("/room/list.jsp").forward(req, resp);
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
        String phone = req.getParameter("phone");
        Date day = Date.valueOf(req.getParameter("day"));
        int idThanhToan = Integer.parseInt(req.getParameter("idThanhToan"));
        Room room = new Room(id, name, phone, day, idThanhToan);
        roomService.updateRoom(room);
        showList(req, resp);
    }


    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        Date day = Date.valueOf(req.getParameter("day"));
        int idThanhToan = Integer.parseInt(req.getParameter("idThanhToan"));
        Room room = new Room(name, phone, day, idThanhToan);
        roomService.addProduct(room);
        showList(req, resp);
    }
}
