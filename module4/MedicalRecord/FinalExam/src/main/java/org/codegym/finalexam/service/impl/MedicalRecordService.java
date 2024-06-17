package org.codegym.finalexam.service.impl;

import org.codegym.finalexam.model.MedicalRecord;
import org.codegym.finalexam.repository.IMedicalRecordRepository;
import org.codegym.finalexam.service.IMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MedicalRecordService implements IMedicalRecordService {
    @Autowired
    private IMedicalRecordRepository medicalRecordRepository;
    @Override
    public List<MedicalRecord> findALl() {
        return medicalRecordRepository.findAll();
    }

    @Override
    public Optional<MedicalRecord> findById(String id) {
        return medicalRecordRepository.findById(id);
    }

    @Override
    public Page<MedicalRecord> searchByPatientNameAndRecordClass(String patient, String recordClass, Pageable pageable) {
        return medicalRecordRepository.findMedicalRecordsByPatientNameContainingIgnoreCaseAndRecordClass_NameContainingIgnoreCase(patient, recordClass,pageable);
    }

    @Override
    public void deleteById(String id) {
        medicalRecordRepository.deleteById(id);

    }

    @Override
    public void save(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
    }
}
