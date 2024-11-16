package com.example.demotrangoder.service;

import com.example.demotrangoder.model.Product;
import com.example.demotrangoder.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    // Thêm phương thức để lấy sản phẩm theo mã danh mục
    public Page<Product> findProductsByCategory(String categoryCode, Pageable pageable) {
        return productRepository.findByCategory_CategoryCode(categoryCode, pageable);
    }
}
