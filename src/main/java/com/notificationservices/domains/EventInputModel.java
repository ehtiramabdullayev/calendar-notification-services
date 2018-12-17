package com.notificationservices.domains;

import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 17.12.2018
 * @project notificationservices
 */
public class EventInputModel {
    private String summary;
    private String location;
    private String description;

    private List<AttendanceModel> attendances;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AttendanceModel> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<AttendanceModel> attendances) {
        this.attendances = attendances;
    }
}
