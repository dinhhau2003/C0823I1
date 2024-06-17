package com.example.email.controller;

import com.example.email.model.Email;
import com.example.email.repository.EmailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailBoxRepository emailBoxRepository;

    @GetMapping("")
    public String showBox(Model model) {
        Email email = emailBoxRepository.findAll();
        model.addAttribute("email", email);
        return "box";
    }

    @GetMapping("/update")
    public String showUpdate(Model model) {
        Email email = emailBoxRepository.findAll();
        model.addAttribute("email", email);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("size", new int[]{5, 10, 15, 25, 50, 100});
        return "setting";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("email") Email email) {
        emailBoxRepository.save(email);
        return "redirect:/email";
    }
}
