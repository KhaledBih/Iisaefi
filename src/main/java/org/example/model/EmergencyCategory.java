package org.example.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "emergency_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyCategory {
    @Id
    private String id;

    private String name;

    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @SerializedName("subCategories")
    private List<SubCategory> subCategories;

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static EmergencyCategory fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, EmergencyCategory.class);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SubCategory {
        @Id
        private String id;

        private String name;

        private String description;
    }
}
