package com.example.c1023l1be.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {
    private String fullName;
    private String numberPhone;
    private String imgUrl;
    private Date birthday;
    private String email;
    private Double salary;
    private String address;
    private Boolean isActive;
    private String userName;
    private String password;
    private Integer roleId;
}
