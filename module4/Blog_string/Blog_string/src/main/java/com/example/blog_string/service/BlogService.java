package com.example.blog_string.service;

import com.example.blog_string.entity.Blog;
import com.example.blog_string.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAllBlog(Pageable pageable);
    Page<Blog> searchBlogName(String blogtName, Category category, Pageable pageable);
    void createNewBlog(Blog blog);
    Blog findByIdBlog(String blogId);
    void deleleBlog(String blogId);
}
