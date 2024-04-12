package com.example.on_tap.service;

import com.example.on_tap.model.Product;
import com.example.on_tap.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductService implements IProductService{
    ProductRepositoryImpl productRepository=new ProductRepositoryImpl();
    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAllProduct();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public List<Product> search(String tenCategory, String name) {
        return productRepository.search(tenCategory,name);
    }
}
