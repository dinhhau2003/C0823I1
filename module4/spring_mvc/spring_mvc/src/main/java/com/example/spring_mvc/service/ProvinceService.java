package com.example.spring_mvc.service;

import com.example.spring_mvc.model.Province;
import com.example.spring_mvc.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProvinceService implements IProvinceService{
    @Autowired
    private IProvinceRepository provinceRepository;
    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }
}
