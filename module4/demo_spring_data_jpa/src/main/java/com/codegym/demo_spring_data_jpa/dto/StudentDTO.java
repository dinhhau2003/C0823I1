package com.codegym.demo_spring_data_jpa.dto;

import com.codegym.demo_spring_data_jpa.model.Classes;
import com.codegym.demo_spring_data_jpa.validate.Group1;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentDTO implements Validator {

    private int id;
    private int gender;
//    @NotEmpty(message = "Require not empty")
//    @Pattern(regexp = "^[A-Z][a-z]+$", message = "Not match regex")
    private String name;


    private Integer age;
    private Classes classes;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @NotNull(message = "require not null")

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public StudentDTO() {
    }

    public StudentDTO(int id, int gender, String name) {
        this.id = id;
        this.gender = gender;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
      StudentDTO studentDTO =(StudentDTO) target;
      if (studentDTO.getName().equals("")){
          errors.rejectValue("name",null,"Not Empty");
      }else if (!studentDTO.getName().matches("^[A-Z][a-z]+$")){
          errors.rejectValue("name",null,"Not match");
      }

    }
}
