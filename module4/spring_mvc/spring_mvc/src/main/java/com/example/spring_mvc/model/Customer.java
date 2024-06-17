package com.example.spring_mvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Entity
@Table(name = "customer")
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotEmpty
//    @Pattern(regexp = "^[a-zA-Z]*$", message = "ten chi chua ky tu")
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "province_id")
    private Province province;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer=(Customer) target;
        if (customer.getFirstName().equals("")){
            errors.rejectValue("firstName",null,"Not Empty");
        }else if (!customer.getFirstName().matches("^[A-Z][a-z]+$")){
            errors.rejectValue("firstName",null,"Not match");
        }
    }
}
