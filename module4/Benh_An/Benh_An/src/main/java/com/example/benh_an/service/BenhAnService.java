package com.example.benh_an.service;

import com.example.benh_an.entity.BenhAn;
import com.example.benh_an.repository.BenhAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BenhAnService implements IBenhAnService{
    @Autowired
    private BenhAnRepository benhAnRepository;
    @Override
    public Page<BenhAn> findAllBenhAn(Pageable pageable) {
        return benhAnRepository.findAll(pageable);
    }

    @Override
    public void createNewBenhAn(BenhAn benhAn) {
        benhAnRepository.save(benhAn);
    }
}
