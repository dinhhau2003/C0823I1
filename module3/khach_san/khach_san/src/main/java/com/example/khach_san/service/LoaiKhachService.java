package com.example.khach_san.service;

import com.example.khach_san.model.LoaiKhach;
import com.example.khach_san.repository.LoaiKhachRepository;

import java.util.List;

public class LoaiKhachService implements ILoaiKhachService {
    LoaiKhachRepository loaiKhachRepository=new LoaiKhachRepository();

    @Override
    public List<LoaiKhach> findAllLoaiKhach() {
        return loaiKhachRepository.findAllLoaiKhach();
    }
}
