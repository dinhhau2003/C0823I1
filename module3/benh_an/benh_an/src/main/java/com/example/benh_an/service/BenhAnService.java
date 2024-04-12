package com.example.benh_an.service;

import com.example.benh_an.model.BenhAn;
import com.example.benh_an.repository.BenhAnRepositoryImpl;

import java.util.List;

public class BenhAnService implements IBenhAnService{
    BenhAnRepositoryImpl benhAnRepository=new BenhAnRepositoryImpl();
    @Override
    public List<BenhAn> findAllBenhAn() {
        return benhAnRepository.findAllBenhAn();
    }

    @Override
    public void addBenhAn(BenhAn benhAn) {
        benhAnRepository.addBenhAn(benhAn);
    }

    @Override
    public BenhAn findById(int id) {
        return benhAnRepository.findById(id);
    }

    @Override
    public void update(BenhAn benhAn) {
        benhAnRepository.update(benhAn);
    }
}
