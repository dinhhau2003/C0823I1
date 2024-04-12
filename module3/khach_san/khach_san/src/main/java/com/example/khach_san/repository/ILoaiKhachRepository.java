package com.example.khach_san.repository;

import com.example.khach_san.model.LoaiKhach;

import java.util.List;

public interface ILoaiKhachRepository {
    List<LoaiKhach> findAllLoaiKhach();
}
