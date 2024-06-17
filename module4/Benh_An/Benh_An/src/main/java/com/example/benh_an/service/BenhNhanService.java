package com.example.benh_an.service;

import com.example.benh_an.entity.BenhNhan;
import com.example.benh_an.repository.BenhNhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BenhNhanService implements IBenhNhanService{
    @Autowired
    private BenhNhanRepository benhNhanRepository;
    @Override
    public List<BenhNhan> findAllBenhNhan() {
        return benhNhanRepository.findAll();
    }
}
