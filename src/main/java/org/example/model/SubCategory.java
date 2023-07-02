package org.example.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sub_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory {
    @Id
    private String id;

    private String name;

    private String description;

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static SubCategory fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, SubCategory.class);
    }
}
