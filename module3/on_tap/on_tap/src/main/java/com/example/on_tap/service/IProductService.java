package com.example.on_tap.service;

import com.example.on_tap.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct();
    void addProduct(Product product);
    Product findById(int id);
    void update(Product product);
    boolean delete(int id);
    List<Product> search(String tenCategory,String name);
}
