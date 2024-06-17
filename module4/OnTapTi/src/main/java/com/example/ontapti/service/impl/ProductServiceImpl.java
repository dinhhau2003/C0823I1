package com.example.ontapti.service.impl;

import com.example.ontapti.entity.Product;
import com.example.ontapti.repository.IProductRepository;
import com.example.ontapti.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> searchProductName(String productName, Pageable pageable) {
        return productRepository.findAllByProductNameContaining(productName, pageable);
    }

    @Override
    public void createNewProduct(Product product) {
        productRepository.save(product);
    }
}
