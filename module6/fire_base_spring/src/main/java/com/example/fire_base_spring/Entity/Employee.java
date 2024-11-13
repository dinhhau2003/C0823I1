package com.example.fire_base_spring.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String imageUrl;

    public Employee() {
    }

    public Employee(Long id, String name, String address, String phone, String imageUrl) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.imageUrl = imageUrl;
    }
}
