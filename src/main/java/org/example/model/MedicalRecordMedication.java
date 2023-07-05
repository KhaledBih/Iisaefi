package org.example.model;
import javax.persistence.*;
@Entity
@Table(name = "MedicalRecord_medications")
public class MedicalRecordMedication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;

    @Column(name = "medication")
    private String medication;

    // Getters and setters
    // ...
}

