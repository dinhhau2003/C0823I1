package com.example.benh_an.repository;

import com.example.benh_an.model.BenhAn;
import com.example.benh_an.model.BenhNhan;

import java.util.List;

public interface IBenhAnRepositoryImpl {
    List<BenhAn> findAllBenhAn();
    void addBenhAn(BenhAn benhAn);
    BenhAn findById(int id);
    void update(BenhAn benhAn);
}
