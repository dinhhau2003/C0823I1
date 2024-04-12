package com.example.thi.service;

import com.example.thi.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct();
    void addProduct(Product product);
    void updateProduct(Product product);
    Product findById(int id);
    boolean deleteProduct(int id);
    List<Product> search(String tenDanhMuc, String name);
}
