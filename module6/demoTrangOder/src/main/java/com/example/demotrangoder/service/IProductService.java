package com.example.demotrangoder.service;

import com.example.demotrangoder.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    // Thêm phương thức để lấy sản phẩm theo mã danh mục
    Page<Product> findProductsByCategory(String categoryCode, Pageable pageable);
}
