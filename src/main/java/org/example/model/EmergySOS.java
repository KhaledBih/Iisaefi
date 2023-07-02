package org.example.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "emergency_sos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergySOS {
    @Id
    private String id;

    private String createBy;

    private String phoneNumber;

    @SerializedName("namePatient")
    private String namePatient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @SerializedName("address")
    private Address address;

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static EmergySOS fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, EmergySOS.class);
    }
}
