package com.example.product.service;

import com.example.product.dto.ProductDto;
import com.example.product.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    public List<Product> findAll();
    public List<ProductDto> findAllDto();
    public boolean add(Product newProduct) throws SQLException;
    public boolean deleteById(int id);
    public boolean update(Product product);
    public Product findById(int id);
    public List<ProductDto> search(String name, int manufactor);

}
