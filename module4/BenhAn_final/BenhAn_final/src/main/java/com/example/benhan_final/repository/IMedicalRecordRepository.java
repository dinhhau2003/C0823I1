package com.example.benhan_final.repository;

import com.example.benhan_final.entity.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord,String> {
}
