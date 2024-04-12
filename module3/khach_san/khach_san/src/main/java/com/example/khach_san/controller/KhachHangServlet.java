package com.example.khach_san.controller;

import com.example.khach_san.model.KhachHang;
import com.example.khach_san.model.LoaiKhach;
import com.example.khach_san.service.KhachService;
import com.example.khach_san.service.LoaiKhachService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "KhachHangServlet", value = "/khach")
public class KhachHangServlet extends HttpServlet {
    KhachService khachService = new KhachService();
    LoaiKhachService loaiKhachService = new LoaiKhachService();

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
        List<LoaiKhach> loaiKhachs = loaiKhachService.findAllLoaiKhach();
        req.setAttribute("loaiKhachs", loaiKhachs);
        String tenLoaiKhach = req.getParameter("tenLoaiKhach");
        String name = req.getParameter("name");
        List<KhachHang> khachHangs =khachService.search(tenLoaiKhach, name);
        req.setAttribute("khachHangs", khachHangs);
        req.getRequestDispatcher("/khach/list.jsp").forward(req,resp);
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LoaiKhach> loaiKhachs = loaiKhachService.findAllLoaiKhach();
        req.setAttribute("loaiKhachs", loaiKhachs);
        int id = Integer.parseInt(req.getParameter("idUpdate"));
        KhachHang khachHang = khachService.findById(id);
        req.setAttribute("khachHang", khachHang);
        req.getRequestDispatcher("/khach/update.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idDelete"));
        khachService.delete(id);
        showList(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LoaiKhach> loaiKhachs = loaiKhachService.findAllLoaiKhach();
        req.setAttribute("loaiKhachs", loaiKhachs);
        req.getRequestDispatcher("/khach/create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LoaiKhach> loaiKhachs = loaiKhachService.findAllLoaiKhach();
        req.setAttribute("loaiKhachs", loaiKhachs);
        List<KhachHang> khachHangs = khachService.findAllKhach();
        req.setAttribute("khachHangs", khachHangs);
        req.getRequestDispatcher("/khach/list.jsp").forward(req, resp);
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
        int id=Integer.parseInt(req.getParameter("id"));
        int maLoaiKhach = Integer.parseInt(req.getParameter("ma"));
        String name = req.getParameter("name");
        Date day = Date.valueOf(req.getParameter("day"));
        Boolean gender = Boolean.valueOf(req.getParameter("gender"));
        String cmnd = req.getParameter("cmnd");
        KhachHang khachHang=new KhachHang(id,maLoaiKhach,name,day,gender,cmnd);
        khachService.update(khachHang);
        showList(req,resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maLoaiKhach = Integer.parseInt(req.getParameter("ma"));
        String name = req.getParameter("name");
        Date day = Date.valueOf(req.getParameter("day"));
        Boolean gender = Boolean.valueOf(req.getParameter("gender"));
        String cmnd = req.getParameter("cmnd");
        KhachHang khachHang = new KhachHang(maLoaiKhach, name, day, gender, cmnd);
        khachService.addKhachHang(khachHang);
        showList(req, resp);
    }
}
