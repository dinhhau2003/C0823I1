package com.example.product_final.service;

import com.example.product_final.entity.Category;
import com.example.product_final.entity.Product;
import com.example.product_final.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Page<Product> findAllProduct(Pageable pageable) {
        return productRepository.findAll(pageable);
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
    public Page<Product> searchProduct(String productName, Category category, Pageable pageable) {
        if (category == null) {
            return productRepository.findAllByProductNameContaining(productName, pageable);
        } else {
            return productRepository.findAllByProductNameContainingAndCategory(productName, category, pageable);
        }
    }
}
