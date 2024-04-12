package com.example.product.repository;

import com.example.product.dto.ProductDto;
import com.example.product.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductRepository {
    public List<ProductDto> findAllDto();
    public List<Product> findAll();
    public boolean add(Product newProduct) throws SQLException;
    public boolean deleteById(int id);
    public boolean update(Product product);
    public Product findById(int id);
    public List<ProductDto> search(String name, int manufactor);

}
