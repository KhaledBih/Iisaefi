package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "MedicalRecord_allergies")
public class MedicalRecordAllergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;

    @Column(name = "allergy")
    private String allergy;

    // Getters and setters
    // ...
}

