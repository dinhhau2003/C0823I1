package org.codegym.finalexam.repository;

import org.codegym.finalexam.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord,String> {
    Page<MedicalRecord> findMedicalRecordsByPatientNameContainingIgnoreCaseAndRecordClass_NameContainingIgnoreCase(String patient, String recordClass, Pageable pageable);
}
