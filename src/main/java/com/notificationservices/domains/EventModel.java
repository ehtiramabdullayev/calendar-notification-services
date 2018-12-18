package com.notificationservices.domains;


import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 17.12.2018
 * @project notificationservices
 */
public class EventModel {
    private String summary;
    private String location;
    private String description;

    private List<AttendeeModel> attendees;

    private String colorId;
    private EventDateTimeModel start;
    private EventDateTimeModel end;
    private Boolean endTimeUnspecified;
    private String etag;
    private Boolean guestsCanInviteOthers;
    private Boolean guestsCanModify;
    private Boolean guestsCanSeeOtherGuests;
    private String hangoutLink;
    private String htmlLink;
    private String iCalUID;
    private String id;
    private String kind;
    private Boolean locked;
    //    private Event.Organizer organizer;
//    private EventDateTime originalStartTime;
    private Boolean privateCopy;
    private List<String> recurrence;
    private String recurringEventId;
    //    private Event.Reminders reminders;
    private Integer sequence;
    //    private Event.Source source;
    private String status;
    //    private String summary;
    private String transparency;
    //    private DateTime updated;
    private String visibility;


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

    public List<AttendeeModel> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<AttendeeModel> attendees) {
        this.attendees = attendees;
    }

    public String getColorId() {
        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public Boolean getEndTimeUnspecified() {
        return endTimeUnspecified;
    }

    public void setEndTimeUnspecified(Boolean endTimeUnspecified) {
        this.endTimeUnspecified = endTimeUnspecified;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Boolean getGuestsCanInviteOthers() {
        return guestsCanInviteOthers;
    }

    public void setGuestsCanInviteOthers(Boolean guestsCanInviteOthers) {
        this.guestsCanInviteOthers = guestsCanInviteOthers;
    }

    public Boolean getGuestsCanModify() {
        return guestsCanModify;
    }

    public void setGuestsCanModify(Boolean guestsCanModify) {
        this.guestsCanModify = guestsCanModify;
    }

    public Boolean getGuestsCanSeeOtherGuests() {
        return guestsCanSeeOtherGuests;
    }

    public void setGuestsCanSeeOtherGuests(Boolean guestsCanSeeOtherGuests) {
        this.guestsCanSeeOtherGuests = guestsCanSeeOtherGuests;
    }

    public String getHangoutLink() {
        return hangoutLink;
    }

    public void setHangoutLink(String hangoutLink) {
        this.hangoutLink = hangoutLink;
    }

    public String getHtmlLink() {
        return htmlLink;
    }

    public void setHtmlLink(String htmlLink) {
        this.htmlLink = htmlLink;
    }

    public String getiCalUID() {
        return iCalUID;
    }

    public void setiCalUID(String iCalUID) {
        this.iCalUID = iCalUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getPrivateCopy() {
        return privateCopy;
    }

    public void setPrivateCopy(Boolean privateCopy) {
        this.privateCopy = privateCopy;
    }

    public List<String> getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(List<String> recurrence) {
        this.recurrence = recurrence;
    }

    public String getRecurringEventId() {
        return recurringEventId;
    }

    public void setRecurringEventId(String recurringEventId) {
        this.recurringEventId = recurringEventId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransparency() {
        return transparency;
    }

    public void setTransparency(String transparency) {
        this.transparency = transparency;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public EventDateTimeModel getEnd() {
        return end;
    }

    public void setEnd(EventDateTimeModel end) {
        this.end = end;
    }

    public EventDateTimeModel getStart() {
        return start;
    }

    public void setStart(EventDateTimeModel start) {
        this.start = start;
    }

}
