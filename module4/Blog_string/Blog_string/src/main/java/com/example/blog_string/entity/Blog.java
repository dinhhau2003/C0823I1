package com.example.blog_string.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Blog {
    @Id
    @NotBlank(message = "Không được để trống")
    private String blogId;
    @NotBlank(message = "Không được để trống")
    private String blogName;
    @NotNull(message = "Không được để trống")
    private LocalDate dateOfBlog;
    @NotNull(message = "Không được để trống")
    private String blogContent;

   @ManyToOne
   @JoinColumn(name = "categoryId",referencedColumnName = "categoryId")
   @NotNull(message = "Không được để trống")
   private Category category;

    public Blog() {
    }

    public Blog(String blogId, String blogName, LocalDate dateOfBlog, String blogContent, Category category) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.dateOfBlog = dateOfBlog;
        this.blogContent = blogContent;
        this.category = category;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public LocalDate getDateOfBlog() {
        return dateOfBlog;
    }

    public void setDateOfBlog(LocalDate dateOfBlog) {
        this.dateOfBlog = dateOfBlog;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
