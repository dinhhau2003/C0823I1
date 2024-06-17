package com.example.blog_string.controller;

import com.example.blog_string.entity.Blog;
import com.example.blog_string.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductAPI {
    @Autowired
    BlogService blogService;
    @PostMapping("/info/{id}")
    public ResponseEntity<Blog> detail(@PathVariable("id") String id){
        Blog product=blogService.findByIdBlog(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
