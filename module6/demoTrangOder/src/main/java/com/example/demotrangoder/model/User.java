package com.example.demotrangoder.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String address;
    private String birthday;
    private String createdAt;
    private String email;
    private String fullName;
    private String gender;
    private String imgUrl;
    private Boolean isActive;
    private String numberPhone;
    private String password;
    private Double salary;
    private String updatedAt;
    private String userName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<CallOderRequest> callOderRequests;
}