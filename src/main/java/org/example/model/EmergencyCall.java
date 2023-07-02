package org.example.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emergency_call")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyCall {
    @Id
    private String id;

    @Column(name = "patient_name")
    @SerializedName("patientName")
    private String patientName;

    private String description;

    @Enumerated(EnumType.STRING)
    private EmergencyStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    @SerializedName("createAt")
    private Date createAt;

    @Column(name = "is_by_call")
    @SerializedName("isByCall")
    private boolean isByCall;

    @Enumerated(EnumType.STRING)
    @SerializedName("addBy")
    private UserRole addBy;

    @Column(name = "create_by")
    @SerializedName("createBy")
    private String createBy;

    @Column(name = "phone_number")
    @SerializedName("phoneNumber")
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    private String sex;

    @Column(name = "patient_type")
    @SerializedName("patientType")
    private String patientType;

    @Column(name = "patient_count")
    @SerializedName("patientCount")
    private Integer patientCount;

    @Enumerated(EnumType.STRING)
    @SerializedName("accidentType")
    private AccidentType accidentType;

    @Column(name = "sub_category_id")
    @SerializedName("subCategoryId")
    private String subCategoryId;

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static EmergencyCall fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, EmergencyCall.class);
    }

    public static enum EmergencyStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED,
        CANCELLED,
        REJECTED
    }

    public static enum UserRole {
        USER,
        DOCTOR,
        OPERATOR,
        NURSE
    }

    public static enum AccidentType {
        ACCIDENTS,
        MALADIES,
        FEMMES_ET_MATERNITE,
        TOXICITE
    }
}
