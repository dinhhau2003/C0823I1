package com.example.demopro.service;

import com.example.demopro.model.Product;
import com.example.demopro.repository.CategoryRepositoryImpl;
import com.example.demopro.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService{
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
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    @Override
    public List<Product> search(String tenDanhMuc, String name) {
        return productRepository.search( tenDanhMuc, name);
    }
}
