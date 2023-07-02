package org.example.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "attendance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    @Id
    private String id;

    @SerializedName("clockIn")
    private Date clockIn;

    @SerializedName("clockOut")
    private Date clockOut;

    @SerializedName("duration")
    private String duration;

    @SerializedName("idUser")
    private String idUser;

    @SerializedName("status")
    private Boolean status;

    @SerializedName("nameUser")
    private String nameUser;

    @SerializedName("phoneUser")
    private String phoneUser;

    @ElementCollection
    @MapKeyColumn(name = "position_key")
    private Map<String, Double> position;

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Attendance fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Attendance.class);
    }

    @Data
    @AllArgsConstructor
    public static class AttendanceList {
        @SerializedName("attendanceList")
        private List<Attendance> attendanceList;

        public String toJson() {
            Gson gson = new Gson();
            return gson.toJson(this);
        }

        public static AttendanceList fromJson(String json) {
            Gson gson = new Gson();
            return gson.fromJson(json, AttendanceList.class);
        }
    }
}
