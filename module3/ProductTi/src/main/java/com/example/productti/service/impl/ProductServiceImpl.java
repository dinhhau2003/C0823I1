package com.example.productti.service.impl;

import com.example.productti.model.Product;
import com.example.productti.repository.impl.ProductRepositoryImpl;
import com.example.productti.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAllProduct();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public List<Product> search(String name) {
        return productRepository.search(name);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }


}
