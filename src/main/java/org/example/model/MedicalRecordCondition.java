package org.example.model;
import javax.persistence.*;
@Entity
@Table(name = "MedicalRecord_conditions")
public class MedicalRecordCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;

    @Column(name = "condition")
    private String condition;

    // Getters and setters
    // ...
}

