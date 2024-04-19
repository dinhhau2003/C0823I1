package com.codegym.demo_spring_mvc.controller;


import com.codegym.demo_spring_mvc.model.Student;
import com.codegym.demo_spring_mvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    @GetMapping("/student")
//    public String showList(ModelMap model){
//        List<Student> studentList = studentService.findAll();
//        model.addAttribute("studentList",studentList);
//
//        return "list";
//    }

    @GetMapping("")
    public ModelAndView showList(){
        List<Student> studentList = studentService.findAll();
//        ModelAndView modelAndView = new ModelAndView("list","studentList",studentList);
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("studentList",studentList);
        return modelAndView;
    }
    @GetMapping("/detail")
    public String detail1(@RequestParam(required = false,defaultValue = "3") int id, Model model){
        model.addAttribute("student",studentService.findById(id));
        return "detail";
    }
//    @GetMapping("/detail/{id}")
    @GetMapping("/detail/{id:[1-2]}")
    public String detail2(@PathVariable(name = "id",required = false) int detailId, Model model){
        model.addAttribute("student",studentService.findById(detailId));
        return "detail";
    }
    @GetMapping("/create")
    public String showFormCreate(){
        return "create";
    }
    @PostMapping("/create")
    public String save(@RequestParam int id, @RequestParam String name, RedirectAttributes redirectAttributes){
        Student student = new Student(id,name);
        redirectAttributes.addFlashAttribute("mess","add success");
        studentService.save(student);
        return "redirect:/students";
    }
}
