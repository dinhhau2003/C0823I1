package com.example.benhan.service;

import com.example.benhan.entity.RecordClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordClassService implements IRecordClassService{
    @Autowired
    private IRecordClassService iRecordClassService;
    @Override
    public List<RecordClass> findAll() {
        return iRecordClassService.findAll();
    }
}
