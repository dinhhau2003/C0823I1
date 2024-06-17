package com.example.blog_string.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Category {
    @Id
    private String categoryId;
    private String categoryName;
    @JsonBackReference
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Blog> blogs;

    public Category() {
    }

    public Category(String categoryId, String categoryName, Set<Blog> blogs) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.blogs = blogs;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
