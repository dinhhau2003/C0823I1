package com.example.final_1.controller;

import com.example.final_1.entity.Category;
import com.example.final_1.entity.Product;
import com.example.final_1.service.ICategoryService;
import com.example.final_1.service.ProductService;
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
    private ProductService productService;
    @ModelAttribute("categories")
    public List<Category> findAllCategories(){
        return categoryService.findAllCategory();
    }
    @GetMapping("/list")
    public String listProduct(Model model, @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(3);
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
                                    @RequestParam("productName") String productName,
                                    @RequestParam(value = "category", required = false) Category category,
                                    Model model) {
        productName = productName.trim();
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        model.addAttribute("productName", productName);
        model.addAttribute("category", category);
        Page<Product> products = productService.searchProducts(productName, category, PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("size", pageSize);
        model.addAttribute("totalPages", products.getTotalPages());
        return "product/list";
    }
    @GetMapping("/create")
    public String viewCreateBlog(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product/create";
    }
    @PostMapping("/create")
    public String create( @ModelAttribute("product") Product product,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product/create";
        }
        productService.createNewProduct(product);
        return "redirect:/product/list";
    }
    @GetMapping("/update/{id}")
    public String viewUpdateProduct(@PathVariable("id") Long id, Model model) {
        Product product = productService.findByIdProduct(id);
        model.addAttribute("product", product);
        return "product/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("product")  Product product,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "product/update";
        }
        productService.createNewProduct(product);
        return "redirect:/product/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productService.deleleProduct(id);
        return "redirect:/product/list";
    }
}
