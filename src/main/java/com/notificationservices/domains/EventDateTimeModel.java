package com.notificationservices.domains;

/**
 * @author Ehtiram_Abdullayev on 18.12.2018
 * @project notificationservices
 */
public class EventDateTimeModel {
    private String dateTime;
    private String timeZone;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
