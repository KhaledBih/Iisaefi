package org.example.model;

import java.util.Date;

import com.google.gson.Gson;


import javax.persistence.*;
import java.util.Date;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "user") // Spécifiez le nom de la table dans la base de données
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING) // Indiquez que c'est une colonne ENUM stockant des noms de rôles
    private UserRole role;

    private String token;

    @Temporal(TemporalType.TIMESTAMP) // Indiquez le type de persistance de la date
    @Column(name = "create_at")
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP) // Indiquez le type de persistance de la date
    @Column(name = "update_at")
    private Date updateAt;

    @OneToOne(cascade = CascadeType.ALL) // Indiquez une relation OneToOne avec MedicalRecord
    @JoinColumn(name = "medical_record_id") // Le nom de la colonne dans la table qui fait référence à MedicalRecord
    private MedicalRecord medicalRecord;
    public static UserModel fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, UserModel.class);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public enum UserRole {
        USER("user"),
        DOCTOR("doctor"),
        OPERATOR("operator"),
        NURSE("nurse"),
        ADMIN("admin");

        private final String name;

        UserRole(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static UserRole parseRole(String role) {
            switch (role) {
                case "user":
                    return USER;
                case "doctor":
                    return DOCTOR;
                case "operator":
                    return OPERATOR;
                case "nurse":
                    return NURSE;
                case "admin":
                    return ADMIN;
                default:
                    throw new IllegalArgumentException("Invalid role value");
            }
        }
    }
}
