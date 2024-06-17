package com.example.benhan.repository;

import com.example.benhan.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord,String> {
}
