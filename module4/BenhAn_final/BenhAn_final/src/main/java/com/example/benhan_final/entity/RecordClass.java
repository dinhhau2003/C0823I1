package com.example.benhan_final.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class RecordClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecord;
    private String name;
    @OneToMany(mappedBy = "recordClass",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set<MedicalRecord> medicalRecords;

    public RecordClass() {
    }

    public RecordClass(Integer idRecord, String name, Set<MedicalRecord> medicalRecords) {
        this.idRecord = idRecord;
        this.name = name;
        this.medicalRecords = medicalRecords;
    }

    public Integer getIdRecord() {
        return idRecord;
    }

    public void setIdRecord(Integer idRecord) {
        this.idRecord = idRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(Set<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }
}
