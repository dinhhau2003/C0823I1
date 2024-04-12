package com.example.quan_ly_dien_thoai.service;

import com.example.quan_ly_dien_thoai.model.Phone;
import com.example.quan_ly_dien_thoai.repository.PhoneRepositoryImpl;

import java.util.List;

public class PhoneServiceImpl implements IPhoneService{
    PhoneRepositoryImpl phoneRepository=new PhoneRepositoryImpl();
    @Override
    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public void addNewPhone(Phone phone) {
        phoneRepository.addNewPhone(phone);
    }
}
