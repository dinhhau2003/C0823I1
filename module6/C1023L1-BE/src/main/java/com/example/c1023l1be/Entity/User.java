package com.example.c1023l1be.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id" ,nullable = false)
    private Integer userId;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "numberPhone", nullable = false)
    private String numberPhone;
    @Column(name = "img_url")
    private String imgUrl;
    @Column(name = "birthday", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date birthday;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "creat_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creatAt;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    @Column(name = "salary",nullable = false)
    private Double salary;
    @Column(name = "address")
    private String address;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
}
