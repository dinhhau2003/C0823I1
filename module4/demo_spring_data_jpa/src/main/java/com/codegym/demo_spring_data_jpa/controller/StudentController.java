package com.codegym.demo_spring_data_jpa.controller;


import com.codegym.demo_spring_data_jpa.dto.StudentDTO;
import com.codegym.demo_spring_data_jpa.exception.AdminExeption;
import com.codegym.demo_spring_data_jpa.model.Student;
import com.codegym.demo_spring_data_jpa.service.IStudentService;
import com.codegym.demo_spring_data_jpa.validate.Group1;
import dto.StudentInfo;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private static int count = 0;
    @Autowired
    private IStudentService studentService;

    @GetMapping("/dto")
    public String showList(ModelMap model) {
        List<StudentInfo> studentList = studentService.findStudentDtoAll();
        model.addAttribute("studentList", studentList);
        return "student/list";
    }

//    @GetMapping("")
//    public String showList(@PageableDefault(page = 0,size = 2,sort = "name",direction = Sort.Direction.ASC) Pageable pageable, ModelMap model){
//
//        Page<Student> studentPage = studentService.searchByName("",pageable);
//        model.addAttribute("studentPage",studentPage);
//        return "student/list";
//    }

    @GetMapping("")
    public String showList(@RequestParam(required = false, defaultValue = "0") int page,
                           @RequestParam(required = false, defaultValue = "") String searchName,
                           ModelMap model) {

        Sort sort = Sort.by("name").ascending().and(Sort.by("gender").descending());
        Pageable pageable = PageRequest.of(page, 2, sort);

        Page<Student> studentPage = studentService.searchByName(searchName, pageable);
        model.addAttribute("studentPage", studentPage);
        model.addAttribute("searchName", searchName);
        return "student/list";
    }

    @GetMapping("/detail")
    public String detail1(@RequestParam(required = false, defaultValue = "3") int id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "student/detail";
    }

    @GetMapping("/detail/{id}")
//    @GetMapping("/detail/{id:[1-2]}")
    public String detail2(@PathVariable(name = "id", required = false) int detailId, Model model) {
        model.addAttribute("student", studentService.findById(detailId));
        return "student/detail";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("studentDTO", new StudentDTO());
        return "student/create";
    }

    @PostMapping("/create")
    public String save(@Validated @ModelAttribute StudentDTO studentDTO,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) throws AdminExeption {

        new StudentDTO().validate(studentDTO, bindingResult);
        Student targetStudent = new Student();
        if (bindingResult.hasErrors()) {

            return "student/create";
        }
        BeanUtils.copyProperties(studentDTO, targetStudent);
        studentService.save(targetStudent);

        redirectAttributes.addFlashAttribute("mess", "add success");
        return "redirect:/students";
    }

    @ExceptionHandler(AdminExeption.class)
    public String handleAdmin(){
        return "admin-error";
    }
}
