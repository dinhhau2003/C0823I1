package com.example.caculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService{

    @Override
    public double convert(double usd, double rate) {
        return usd* rate;
    }
}
