package com.example.benhan.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class RecordClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "recordClass",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    private Set<MedicalRecord> medicalRecords;

    public RecordClass() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
