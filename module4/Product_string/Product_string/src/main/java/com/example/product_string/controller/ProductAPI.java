package com.example.product_string.controller;

import com.example.product_string.entity.Product;
import com.example.product_string.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductAPI {
    @Autowired
    ProductService productService;
    @PostMapping("/info/{id}")
    public ResponseEntity<Product> detail(@PathVariable("id") Long id){
        Product product=productService.findByIdProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
