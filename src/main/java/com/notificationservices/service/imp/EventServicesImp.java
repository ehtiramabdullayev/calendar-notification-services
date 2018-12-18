package com.notificationservices.service.imp;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.*;
import com.notificationservices.domains.AttendeeModel;
import com.notificationservices.domains.EventModel;
import com.notificationservices.domains.mapper.GeneralEventMapper;
import com.notificationservices.service.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.notificationservices.config.Utils.*;
import static com.notificationservices.service.imp.LoginServicesImp.getCredentials;

/**
 * @author Ehtiram_Abdullayev on 17.12.2018
 * @project notificationservices
 */
@Service
public class EventServicesImp implements EventServices {

    @Autowired
    private GeneralEventMapper eventMapper;

    @Override
    public String createEvent(EventModel eventInput) throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Credential credential = getCredentials(HTTP_TRANSPORT);


        Event event = new Event();
        event.setSummary(eventInput.getSummary());
        event.setLocation(eventInput.getLocation());
        event.setDescription(eventInput.getDescription());

        DateTime startDateTime = new DateTime("2018-05-28T09:00:00-07:00");
        EventDateTime start = new EventDateTime()
                .setDateTime(startDateTime)
                .setTimeZone("America/Los_Angeles");
        event.setStart(start);

        // will be out end date time
        DateTime endDateTime = new DateTime("2019-05-28T17:00:00-07:00");
        EventDateTime end = new EventDateTime()
                .setDateTime(endDateTime)
                .setTimeZone("America/Los_Angeles");
        event.setEnd(end);

        String[] recurrence = new String[]{"RRULE:FREQ=DAILY;COUNT=2"};
        event.setRecurrence(Arrays.asList(recurrence));


        //TODO - make this right !
        //adding people to notice
        List<EventAttendee> attendees = new ArrayList<>();
        for (AttendeeModel attendeeModel : eventInput.getAttendances()) {
            EventAttendee attendee = new EventAttendee();
            attendee.setEmail(attendeeModel.getEmail());
            attendees.add(attendee);
        }
        event.setAttendees(attendees);

        EventReminder[] reminderOverrides = new EventReminder[]{
                new EventReminder().setMethod("email").setMinutes(24 * 60),
                new EventReminder().setMethod("popup").setMinutes(10),
        };
        Event.Reminders reminders = new Event.Reminders()
                .setUseDefault(false)
                .setOverrides(Arrays.asList(reminderOverrides));
        event.setReminders(reminders);

        String calendarId = "primary";
        System.out.printf("Event created: %s\n", event.getHtmlLink());
//        createEvent()
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
        event = service.events().insert(calendarId, event).execute();

        return "OK";
    }

    @Override
    public List<EventModel> getClientEvents() throws GeneralSecurityException, IOException {
        List<EventModel> eventOutputModels = new ArrayList<>();
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Credential credential = getCredentials(HTTP_TRANSPORT);
        Calendar service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

        // List the next 10 events from the primary calendar.
        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = service.events().list("primary")
                .setMaxResults(10)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
        List<Event> items = events.getItems();

        if (items.isEmpty()) {
        } else {
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                EventModel outputModel = eventMapper.toEventModel(event);
                eventOutputModels.add(outputModel);
            }
        }

        return eventOutputModels;
    }


}