package com.example.demotrangoder.controller;

import com.example.demotrangoder.model.Category;
import com.example.demotrangoder.model.Product;
import com.example.demotrangoder.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
@CrossOrigin(origins = "*")

public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public ResponseEntity<Page<Product>> findAllCategory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productService.findAll(pageable);
        return ResponseEntity.ok(products);
    }
    // Thêm API để lấy sản phẩm theo mã danh mục
    @GetMapping("/category/{categoryCode}")
    public ResponseEntity<Page<Product>> findProductsByCategory(
            @PathVariable String categoryCode,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productService.findProductsByCategory(categoryCode, pageable);
        return ResponseEntity.ok(products);
    }
}
