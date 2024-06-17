package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping("")
    public String showList(ModelMap model){
        model.addAttribute("customerList",productRepository.findAll());
        return "product/list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product",new Product());
        return"product/create";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Product product){
        productRepository.save(product);
        return "redirect:/product";
    }
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam("id") int id,Model model){
        Product product=productRepository.findById(id);
        model.addAttribute("product",product);
        return  "product/update";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute Product product){
        productRepository.save(product);
        return "redirect:/product";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        productRepository.delete(id);
        return "redirect:/product";
    }
    @GetMapping("/detail")
    public String detail1(@RequestParam("id") int id, Model model){
        model.addAttribute("product",productRepository.findById(id));
        return "product/detail";
    }
    @GetMapping("/search")
    public String searchByName(@RequestParam("name") String name, Model model) {
        List<Product> searchResults = productRepository.findByName(name);
        model.addAttribute("customerList", searchResults);
        return "product/list";
    }
}
