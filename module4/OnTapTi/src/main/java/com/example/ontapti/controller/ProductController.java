package com.example.ontapti.controller;

import com.example.ontapti.entity.Category;
import com.example.ontapti.entity.Product;
import com.example.ontapti.service.ICategoryService;
import com.example.ontapti.service.IProductService;
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
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ICategoryService categoryService;

    @Autowired
    IProductService productService;

    @GetMapping("/list")
    public String listProduct(Model model, @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Product> products = productService.findAllProduct(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", products.getTotalPages());
        return "product/list";
    }

    @GetMapping("/search")
    public String searchProductName(@RequestParam("page") Optional<Integer> page,
                                             @RequestParam("size") Optional<Integer> size,
                                             @RequestParam("productName") String productName, Model model) {
        productName = productName.trim();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        model.addAttribute("productName", productName);
        Page<Product> products = productService.searchProductName(productName, PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", products.getTotalPages());
        return "product/list";
    }

    @ModelAttribute("categories")
    public List<Category> findAllCategories() {
        return categoryService.findAllCategory();
    }

    @GetMapping("/create")
    public String viewCreateStudent(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("product") Product product,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product/create";
        }
        productService.createNewProduct(product);
        return "redirect:/product/list";
    }

}
