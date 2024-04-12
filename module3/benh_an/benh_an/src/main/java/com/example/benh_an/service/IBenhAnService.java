package com.example.benh_an.service;

import com.example.benh_an.model.BenhAn;

import java.util.List;

public interface IBenhAnService {
    List<BenhAn> findAllBenhAn();
    void addBenhAn(BenhAn benhAn);
    BenhAn findById(int id);
    void update(BenhAn benhAn);

}
