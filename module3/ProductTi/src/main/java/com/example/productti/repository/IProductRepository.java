package com.example.productti.repository;

import com.example.productti.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAllProduct();
    void addProduct(Product product);
    boolean deleteProduct(int id);
    List<Product> search(String name);
    Product findById(int id);
    void updateProduct(Product product);

}
