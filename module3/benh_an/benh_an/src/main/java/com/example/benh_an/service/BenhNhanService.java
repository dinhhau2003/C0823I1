package com.example.benh_an.service;

import com.example.benh_an.model.BenhNhan;
import com.example.benh_an.repository.BenhNhanRepository;

import java.util.List;

public class BenhNhanService implements IBenhNhanService{
    BenhNhanRepository benhNhanRepository=new BenhNhanRepository();
    @Override
    public List<BenhNhan> findAllBenhNhan() {
        return benhNhanRepository.findAllBenhNhan();
    }
}
