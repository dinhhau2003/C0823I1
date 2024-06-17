package com.example.benhan.service;

import com.example.benhan.entity.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService implements IMedicalRecordService{
    @Autowired
    private IMedicalRecordService iMedicalRecordService;
    @Override
    public Page<MedicalRecord> findAll(Pageable pageable) {
        return iMedicalRecordService.findAll(pageable);
    }
}
