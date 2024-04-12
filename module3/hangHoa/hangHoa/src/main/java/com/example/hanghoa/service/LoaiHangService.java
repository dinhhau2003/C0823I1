package com.example.hanghoa.service;

import com.example.hanghoa.model.LoaiHang;
import com.example.hanghoa.repository.LoaiHangRepository;

import java.util.List;

public class LoaiHangService implements ILoaiHangService{
    LoaiHangRepository loaiHangRepository=new LoaiHangRepository();
    @Override
    public List<LoaiHang> findAllLoaiHang() {
        return loaiHangRepository.findAllLoaiHang();
    }
}
