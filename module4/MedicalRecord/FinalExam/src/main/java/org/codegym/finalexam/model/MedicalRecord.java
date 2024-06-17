package org.codegym.finalexam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MedicalRecord {
    @Id
    private String id;
    private String patientName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recordClassId",referencedColumnName = "recordClassId")
    private RecordClass recordClass;

}