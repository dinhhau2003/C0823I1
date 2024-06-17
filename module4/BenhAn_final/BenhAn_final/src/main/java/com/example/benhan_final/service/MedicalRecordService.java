package com.example.benhan_final.service;

import com.example.benhan_final.entity.MedicalRecord;
import com.example.benhan_final.repository.IMedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService implements IMedicalRecordService{
    @Autowired
    private IMedicalRecordRepository iMedicalRecordRepository;
    @Override
    public Page<MedicalRecord> findAllMedia(Pageable pageable) {
        return iMedicalRecordRepository.findAll(pageable);
    }
}
