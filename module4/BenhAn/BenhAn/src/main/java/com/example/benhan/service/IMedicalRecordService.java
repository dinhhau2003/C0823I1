package com.example.benhan.service;

import com.example.benhan.entity.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicalRecordService {
    Page<MedicalRecord> findAll(Pageable pageable);

}
