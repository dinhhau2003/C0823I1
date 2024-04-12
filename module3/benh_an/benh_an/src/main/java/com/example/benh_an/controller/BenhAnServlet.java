package com.example.benh_an.controller;

import com.example.benh_an.model.BenhAn;
import com.example.benh_an.model.BenhNhan;
import com.example.benh_an.service.BenhAnService;
import com.example.benh_an.service.BenhNhanService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "BenhAnServlet",value = "/benhAn")
public class BenhAnServlet extends HttpServlet {
    BenhAnService benhAnService=new BenhAnService();
    BenhNhanService benhNhanService=new BenhNhanService();
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
                showUpdate(req, resp);
                break;
            case "delete":
//                delete(req, resp);
                break;
            default:
                showList(req, resp);
                break;
        }
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BenhNhan> benhNhans=benhNhanService.findAllBenhNhan();
        req.setAttribute("benhNhans",benhNhans);
        int id = Integer.parseInt(req.getParameter("idUpdate"));
        BenhAn benhAn =benhAnService.findById(id);
        req.setAttribute("benhAn",benhAn);
        req.getRequestDispatcher("/benhAn/update.jsp").forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BenhNhan> benhNhans = benhNhanService.findAllBenhNhan();
        req.setAttribute("benhNhans", benhNhans);
        req.getRequestDispatcher("/benhAn/create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BenhNhan> benhNhans = benhNhanService.findAllBenhNhan();
        req.setAttribute("benhNhans", benhNhans);
        List<BenhAn> benhAns = benhAnService.findAllBenhAn();
        req.setAttribute("benhAns", benhAns);
        req.getRequestDispatcher("/benhAn/list.jsp").forward(req, resp);
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
        int maBenhAn = Integer.parseInt(req.getParameter("maBenhAn"));
        int maBenhNhan= Integer.parseInt(req.getParameter("maBenhNhan"));
        Date dayNhap = Date.valueOf(req.getParameter("dayNhap"));
        Date dayXuat = Date.valueOf(req.getParameter("dayXuat"));
        String lyDo=req.getParameter("lyDo");
        BenhAn benhAn=new BenhAn(id,maBenhAn,maBenhNhan,dayNhap,dayXuat,lyDo);
        benhAnService.update(benhAn);
        showList(req,resp);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maBenhAn = Integer.parseInt(req.getParameter("maBenhAn"));
        int maBenhNhan= Integer.parseInt(req.getParameter("maBenhNhan"));
        Date dayNhap = Date.valueOf(req.getParameter("dayNhap"));
        Date dayXuat = Date.valueOf(req.getParameter("dayXuat"));
        String lyDo=req.getParameter("lyDo");
        BenhAn benhAn=new BenhAn(maBenhAn,maBenhNhan,dayNhap,dayXuat,lyDo);
        benhAnService.addBenhAn(benhAn);
        showList(req, resp);
    }
}
