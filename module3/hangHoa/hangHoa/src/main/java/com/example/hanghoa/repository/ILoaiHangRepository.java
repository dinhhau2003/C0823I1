package com.example.hanghoa.repository;

import com.example.hanghoa.model.LoaiHang;

import java.util.List;

public interface ILoaiHangRepository {
    List<LoaiHang> findAllLoaiHang();
}
