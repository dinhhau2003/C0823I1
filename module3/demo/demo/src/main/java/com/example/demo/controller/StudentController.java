package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("")
    public String showList(Model model){
        List<Student> students=studentService.findAll();
        model.addAttribute("students",students);
        return "list";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam(required = false ,defaultValue = "3") int id,Model model){
        model.addAttribute("students",studentService.findById(id));
        return "detail";
    }
    @GetMapping("/detail/{id:[1-2]}")
    public String detail2(@PathVariable(name = "id",required = false) int detailId, Model model){
        model.addAttribute("students",studentService.findById(detailId));
        return "detail";
    }
    @GetMapping("/create")
    public String showForm(){
        return "create";
    }
    @PostMapping("/create")
    public String save(@RequestParam int id, @RequestParam String name, RedirectAttributes redirectAttributes){
        Student student=new Student(id,name);
        redirectAttributes.addFlashAttribute("mess","add success");
        studentService.save(student);
        return "redirect:/student";
    }
}
