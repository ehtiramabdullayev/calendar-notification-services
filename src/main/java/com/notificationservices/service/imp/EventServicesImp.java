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
    public EventModel createEvent(EventModel eventInput) throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Credential credential = getCredentials(HTTP_TRANSPORT);
        //TODO smelly code down! fix it asap !
//        if(credential.getAccessToken() == null){
//            EventModel model = new EventModel();
//            model.setDescription(credential.getTokenServerEncodedUrl());
//            return model;
//        }


        Event event = new Event();
        event.setSummary(eventInput.getSummary());
        event.setLocation(eventInput.getLocation());
        event.setDescription(eventInput.getDescription());

        //this is event starting time!
        if(eventInput.getStart()!=null){
            DateTime startDateTime = new DateTime(eventInput.getStart().getDateTime());
            EventDateTime start = new EventDateTime()
                    .setDateTime(startDateTime)
                    .setTimeZone(eventInput.getStart().getTimeZone());
            event.setStart(start);
        }


        // will be out end date time
        if(eventInput.getEnd()!=null) {
            DateTime endDateTime = new DateTime(eventInput.getEnd().getDateTime());
            EventDateTime end = new EventDateTime()
                    .setDateTime(endDateTime)
                    .setTimeZone(eventInput.getEnd().getTimeZone());
            event.setEnd(end);
        }
        String[] recurrence = new String[]{"RRULE:FREQ=DAILY;COUNT=2"};
        event.setRecurrence(Arrays.asList(recurrence));


        //TODO - make this right !
        //adding people to notice
        List<EventAttendee> attendees = new ArrayList<>();
        if(eventInput.getAttendances()!=null){
            for (AttendeeModel attendeeModel : eventInput.getAttendances()) {
                EventAttendee attendee = new EventAttendee();
                attendee.setEmail(attendeeModel.getEmail());
                attendees.add(attendee);
            }
            event.setAttendees(attendees);

        }

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

        EventModel outputEvent = eventMapper.toEventModel(event);

        return outputEvent;
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