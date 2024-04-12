package com.example.on_tap.repository;

import com.example.on_tap.model.Product;

import java.util.List;

public interface IProductRepositoryImpl {
    List<Product> findAllProduct();
    void addProduct(Product product);
    Product findById(int id);
    void update(Product product);
    boolean delete(int id);
    List<Product> search(String tenCategory,String name);
}
