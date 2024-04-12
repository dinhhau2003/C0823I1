package com.example.hanghoa.service;

import com.example.hanghoa.model.HangHoa;

import java.util.List;

public interface IHangService {
    List<HangHoa> findAllHang();
    void addHang(HangHoa hangHoa);
    HangHoa findById(int id);
    void update(HangHoa hangHoa);
    boolean delete(int id);
    List<HangHoa> search(String tenLoaiHang,String name);
}
