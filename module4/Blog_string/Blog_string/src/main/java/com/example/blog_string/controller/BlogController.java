package com.example.blog_string.controller;

import com.example.blog_string.entity.Blog;
import com.example.blog_string.entity.Category;
import com.example.blog_string.service.BlogService;
import com.example.blog_string.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    ICategoryService categoryService;
    @Autowired
    BlogService blogService;
    @ModelAttribute("categories")
    public List<Category> findAllCategories(){
        return categoryService.findAllCategory();
    }
    @GetMapping("/list")
    public String listBlog(Model model, @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
        Page<Blog> blogs = blogService.findAllBlog(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("blogs", blogs.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", blogs.getTotalPages());
        return "blog/list";
    }
    @GetMapping("/search")
    public String searchBlogName(@RequestParam("page") Optional<Integer> page,
                                    @RequestParam("size") Optional<Integer> size,
                                    @RequestParam("blogName") String blogName,
                                    @RequestParam(value = "category", required = false) Category category,
                                    Model model) {
        blogName = blogName.trim();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        model.addAttribute("blogName", blogName);
        model.addAttribute("category", category);
        Page<Blog> blogs = blogService.searchBlogName(blogName, category, PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("blogs", blogs.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", blogs.getTotalPages());
        return "blog/list";
    }
    @GetMapping("/create")
    public String viewCreateBlog(Model model) {
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        return "blog/create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("blog") Blog blog,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "blog/create";
        }
        blogService.createNewBlog(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/update/{id}")
    public String viewUpdateBlog(@PathVariable("id") String id, Model model) {
        Blog blog = blogService.findByIdBlog(id);
        model.addAttribute("blog", blog);
        return "blog/update";
    }
    @PostMapping("/update")
    public String update(@Valid@ModelAttribute("blog")  Blog blog,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "blog/update";
        }
        blogService.createNewBlog(blog);
        return "redirect:/blog/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        blogService.deleleBlog(id);
        return "redirect:/blog/list";
    }
}
