package com.notificationservices.domains;

import com.notificationservices.domains.distance.DistanceResponse;

/**
 * @author Ehtiram_Abdullayev on 18.12.2018
 * @project notificationservices
 */
public class EventMapResult  {
    private String summary;
    private String location;
    private String description;
    private String id;
    private DistanceResponse distanceResponse;
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

    public DistanceResponse getDistanceResponse() {
        return distanceResponse;
    }

    public void setDistanceResponse(DistanceResponse distanceResponse) {
        this.distanceResponse = distanceResponse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
