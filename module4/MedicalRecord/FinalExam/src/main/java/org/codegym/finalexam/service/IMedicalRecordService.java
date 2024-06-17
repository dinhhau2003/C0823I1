package org.codegym.finalexam.service;

import org.codegym.finalexam.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IMedicalRecordService {
    public List<MedicalRecord> findALl();
    public Optional<MedicalRecord> findById(String id);
    public Page<MedicalRecord> searchByPatientNameAndRecordClass(String name, String patient, Pageable pageable);
    public void deleteById(String id);

    void save(MedicalRecord medicalRecord);
}
