package org.codegym.finalexam.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RecordClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "recordClass",cascade = CascadeType.ALL)
    List<MedicalRecord> medicalRecords;
}
