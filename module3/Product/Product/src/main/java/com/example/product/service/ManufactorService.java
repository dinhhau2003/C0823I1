package com.example.product.service;

import com.example.product.model.Manufactor;
import com.example.product.repository.IManufactorRepository;
import com.example.product.repository.ManufactorRepsitory;

import java.util.List;

public class ManufactorService implements IManufactorService{
    private IManufactorRepository manufactorRepository = new ManufactorRepsitory();
    @Override
    public List<Manufactor> getAll() {
        return manufactorRepository.findAll();
    }
}
