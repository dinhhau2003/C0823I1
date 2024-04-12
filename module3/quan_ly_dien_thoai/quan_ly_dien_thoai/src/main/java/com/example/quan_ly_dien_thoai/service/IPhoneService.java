package com.example.quan_ly_dien_thoai.service;

import com.example.quan_ly_dien_thoai.model.Phone;

import java.util.List;

public interface IPhoneService {
    List<Phone> findAll();
    void addNewPhone(Phone phone);
}
