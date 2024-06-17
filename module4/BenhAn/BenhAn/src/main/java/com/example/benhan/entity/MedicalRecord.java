package com.example.benhan.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class MedicalRecord {
    @Id
    private String id;
    private String patientName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    @ManyToOne
    @JoinColumn(name = "recordClassId",referencedColumnName ="recordClassId" )
    private RecordClass recordClass;

    public MedicalRecord() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RecordClass getRecordClass() {
        return recordClass;
    }

    public void setRecordClass(RecordClass recordClass) {
        this.recordClass = recordClass;
    }
}
