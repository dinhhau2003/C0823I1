package com.example.blog_string.repository;

import com.example.blog_string.entity.Blog;
import com.example.blog_string.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

public interface IBlogRepository extends JpaRepository<Blog,String> {
    Page<Blog> findAllByBlogNameContaining(String blogName, Pageable pageable);
    Page<Blog> findAllByBlogNameContainingAndCategory(String blogName, Category category, Pageable pageable);

}
