package com.example.product.service;

import com.example.product.dto.ProductDto;
import com.example.product.model.Product;
import com.example.product.repository.IProductRepository;
import com.example.product.repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductDto> findAllDto() {
        return productRepository.findAllDto();
    }

    @Override
    public boolean add(Product newProduct) throws SQLException {
        return productRepository.add(newProduct);
    }

    @Override
    public boolean deleteById(int id) {
        return productRepository.deleteById(id);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<ProductDto> search(String name, int manufactor) {
        return productRepository.search(name,manufactor);
    }
}
