package com.example.blog_string.service;

import com.example.blog_string.entity.Blog;
import com.example.blog_string.entity.Category;
import com.example.blog_string.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> searchBlogName(String blogName, Category category, Pageable pageable) {
        if (category == null) {
            return blogRepository.findAllByBlogNameContaining(blogName, pageable);
        } else {
            return blogRepository.findAllByBlogNameContainingAndCategory(blogName, category, pageable);
        }
    }

    @Override
    public void createNewBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findByIdBlog(String blogId) {
        return blogRepository.findById(blogId).orElse(null);
    }

    @Override
    public void deleleBlog(String blogId) {
        blogRepository.deleteById(blogId);
    }
}
