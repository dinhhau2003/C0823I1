package org.codegym.finalexam.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codegym.finalexam.model.RecordClass;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

public class MedicalRecordDTO {
    @NotNull
    private String id;
    @NotNull
    @NotBlank
    private String patientName;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private String description;
    private RecordClass recordClass;

    public MedicalRecordDTO(String id, String patientName, LocalDate startDate, LocalDate endDate, String description, RecordClass recordClass) {
        this.id = id;
        this.patientName = patientName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.recordClass = recordClass;
    }

    public MedicalRecordDTO() {
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
