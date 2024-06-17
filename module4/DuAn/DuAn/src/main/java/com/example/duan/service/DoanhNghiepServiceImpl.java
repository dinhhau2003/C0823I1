package com.example.duan.service;

import com.example.duan.entity.DoanhNghiep;
import com.example.duan.repository.DoanhNghiepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DoanhNghiepServiceImpl implements DoanhNghiepService{
    @Autowired
    DoanhNghiepRepository doanhNghiepRepository;

    @Override
    public List<DoanhNghiep> findAllDoanhNghiep() {
        return doanhNghiepRepository.findAll();
    }
}
