package com.example.demopro.repository;

import com.example.demopro.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAllProduct();
    void addProduct(Product product);
    void updateProduct(Product product);
    Product findById(int id);
    boolean deleteProduct(int id);
    List<Product> search(String tenDanhMuc,String name);
}
