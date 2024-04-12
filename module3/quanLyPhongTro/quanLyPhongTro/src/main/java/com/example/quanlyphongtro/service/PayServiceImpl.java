package com.example.quanlyphongtro.service;

import com.example.quanlyphongtro.model.Pay;
import com.example.quanlyphongtro.repository.PayRepositoryImpl;

import java.util.List;

public class PayServiceImpl implements IPayService{
    PayRepositoryImpl payRepository=new PayRepositoryImpl();


    @Override
    public List<Pay> findAllPay() {
        return payRepository.findAllPay();
    }
}
