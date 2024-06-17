package com.codegym.demo_spring_data_jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Jame {
    @Id
    private String username;
    private String password;

}
