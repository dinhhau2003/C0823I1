package com.example.hanghoa.controller;

import com.example.hanghoa.model.HangHoa;
import com.example.hanghoa.model.LoaiHang;
import com.example.hanghoa.service.HangService;
import com.example.hanghoa.service.LoaiHangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "HangHoaServlet", value = "/hang")
public class HangHoaServlet extends HttpServlet {
    HangService hangService=new HangService();
    LoaiHangService loaiHangService=new LoaiHangService();
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
        List<LoaiHang> loaiHangs = loaiHangService.findAllLoaiHang();
        req.setAttribute("loaiHangs", loaiHangs);
        String tenLoaiHang = req.getParameter("tenLoaiHang");
        String name = req.getParameter("name");
        List<HangHoa> hangHoas =hangService.search(tenLoaiHang, name);
        req.setAttribute("hangHoas", hangHoas);
        req.getRequestDispatcher("/hang/list.jsp").forward(req,resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("idDelete"));
        hangService.delete(id);
        showList(req, resp);
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LoaiHang> loaiHangs=loaiHangService.findAllLoaiHang();
        req.setAttribute("loaiHangs",loaiHangs);
        int id = Integer.parseInt(req.getParameter("idUpdate"));
        HangHoa hangHoa =hangService.findById(id);
        req.setAttribute("hangHoa",hangHoa);
        req.getRequestDispatcher("/hang/update.jsp").forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LoaiHang> loaiHangs=loaiHangService.findAllLoaiHang();
        req.setAttribute("loaiHangs",loaiHangs);
        req.getRequestDispatcher("/hang/create.jsp").forward(req, resp);

    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LoaiHang> loaiHangs=loaiHangService.findAllLoaiHang();
        req.setAttribute("loaiHangs",loaiHangs);
        List<HangHoa> hangHoas=hangService.findAllHang();
        req.setAttribute("hangHoas",hangHoas);
        req.getRequestDispatcher("/hang/list.jsp").forward(req, resp);
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
        int idMa= Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String dvt=req.getParameter("dvt");
        Double gia= Double.valueOf(req.getParameter("gia"));
        Date day = Date.valueOf(req.getParameter("day"));
        int id = Integer.parseInt(req.getParameter("ma"));
        HangHoa hangHoa=new HangHoa(idMa,name,dvt,gia,day,id);
        hangService.update(hangHoa);
        showList(req, resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String dvt=req.getParameter("dvt");
        Double gia= Double.valueOf(req.getParameter("gia"));
        Date day = Date.valueOf(req.getParameter("day"));
        int id = Integer.parseInt(req.getParameter("ma"));
        HangHoa hangHoa=new HangHoa(name,dvt,gia,day,id);
        hangService.addHang(hangHoa);
        showList(req, resp);
    }
}
