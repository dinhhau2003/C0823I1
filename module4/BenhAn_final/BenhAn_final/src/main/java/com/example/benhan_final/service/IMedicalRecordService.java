package com.example.benhan_final.service;

import com.example.benhan_final.entity.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicalRecordService {
    Page<MedicalRecord> findAllMedia(Pageable pageable);

}
