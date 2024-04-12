package com.example.khach_san.repository;

import com.example.khach_san.model.KhachHang;

import java.util.List;

public interface IKhachRepositoryImpl {
    List<KhachHang> findAllKhach();
    void addKhachHang(KhachHang khachHang);
    boolean delete(int id);
    KhachHang findById(int id);
    void update(KhachHang khachHang);
    List<KhachHang> search(String tenLoaiKhach,String name);
}
