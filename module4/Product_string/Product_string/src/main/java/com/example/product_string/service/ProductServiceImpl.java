package com.example.product_string.service;

import com.example.product_string.entity.Category;
import com.example.product_string.entity.Product;
import com.example.product_string.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> searchProductName(String productName, Pageable pageable) {
        return productRepository.findAllByNameContaining(productName,pageable);
    }

    @Override
    public void createNewProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findByIdProduct(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public void deleleProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Page<Product> searchProducts(String productName, Category category, Pageable pageable) {
        if (category == null) {
            return productRepository.findAllByNameContaining(productName, pageable);
        } else {
            return productRepository.findAllByNameContainingAndCategory(productName, category, pageable);
        }
    }

}
