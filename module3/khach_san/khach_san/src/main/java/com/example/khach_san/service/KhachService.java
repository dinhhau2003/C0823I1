package com.example.khach_san.service;

import com.example.khach_san.model.KhachHang;
import com.example.khach_san.repository.KhachRepositoryImpl;

import java.util.List;

public class KhachService implements IKhachService{
    KhachRepositoryImpl khachRepository=new KhachRepositoryImpl();
    @Override
    public List<KhachHang> findAllKhach() {
        return khachRepository.findAllKhach();
    }

    @Override
    public void addKhachHang(KhachHang khachHang) {
        khachRepository.addKhachHang(khachHang);
    }

    @Override
    public boolean delete(int id) {
        return khachRepository.delete(id);
    }

    @Override
    public KhachHang findById(int id) {
        return khachRepository.findById(id);
    }

    @Override
    public void update(KhachHang khachHang) {
        khachRepository.update(khachHang);
    }

    @Override
    public List<KhachHang> search(String   tenLoaiKhach , String name ) {
        return khachRepository.search(tenLoaiKhach,name);
    }
}
