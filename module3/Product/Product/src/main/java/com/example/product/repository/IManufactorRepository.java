package com.example.product.repository;

import com.example.product.model.Manufactor;

import java.util.List;

public interface IManufactorRepository {
    List<Manufactor> findAll();
}
