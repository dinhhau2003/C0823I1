package com.example.quan_ly_dien_thoai.repository;

import com.example.quan_ly_dien_thoai.model.Phone;

import java.util.List;

public interface IPhoneRepository {
    List<Phone> findAll();
    void addNewPhone(Phone phone);
}
