package com.example.quanlyphongtro.repository;

import com.example.quanlyphongtro.model.Pay;

import java.util.List;

public interface IPayRepository {
    List<Pay> findAllPay();
}
