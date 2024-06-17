package com.example.benhan_final.service;

import com.example.benhan_final.entity.RecordClass;
import com.example.benhan_final.repository.IRecordClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordClassService implements IRecordClassService{
    @Autowired
    private IRecordClassRepository iRecordClassRepository;
    @Override
    public List<RecordClass> findAll() {
        return iRecordClassRepository.findAll();
    }
}
