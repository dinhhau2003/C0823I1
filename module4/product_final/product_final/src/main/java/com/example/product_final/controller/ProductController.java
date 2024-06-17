package com.example.product_final.controller;

import com.example.product_final.entity.Category;
import com.example.product_final.entity.Product;
import com.example.product_final.service.ICategoryService;
import com.example.product_final.service.IProductService;
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
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;
    @GetMapping("/list")
    public String listProduct(Model model, @RequestParam("page") Optional<Integer> page,
                           @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<Product> products = productService.findAllProduct(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", products.getTotalPages());
        return "product/list";
    }
    @ModelAttribute("categorys")
    public List<Category> findAllCategory() {
        return categoryService.findAllCategory();
    }
    @GetMapping("/create")
    public String viewCreateProduct(Model model) {
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
    @GetMapping("/update/{productId}")
    public String viewUpdateProduct(@PathVariable("productId") Long productId, Model model) {
        Product product = productService.findByIdProduct(productId);
        model.addAttribute("product", product);
        return "product/update";
    }
    @PostMapping("/update")
    public String update(@Valid@ModelAttribute("product")  Product product,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "product/update";
        }
        productService.createNewProduct(product);
        return "redirect:/product/list";
    }
    @GetMapping("/delete/{productId}")
    public String delete(@PathVariable("productId") Long productId) {
        productService.deleleProduct(productId);
        return "redirect:/product/list";
    }
    @GetMapping("/search")
    public String searchProductName(@RequestParam("page") Optional<Integer> page,
                                 @RequestParam("size") Optional<Integer> size,
                                 @RequestParam("productName") String productName,
                                 @RequestParam(value = "category", required = false) Category category,
                                 Model model) {
        productName = productName.trim();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        model.addAttribute("productName", productName);
        model.addAttribute("category", category);
        Page<Product> products = productService.searchProduct(productName, category, PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", products.getTotalPages());
        return "product/list";
    }
}
