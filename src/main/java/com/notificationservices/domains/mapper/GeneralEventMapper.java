package com.notificationservices.domains.mapper;

/**
 * @author Ehtiram_Abdullayev on 18.12.2018
 * @project notificationservices
 */

import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.notificationservices.domains.AttendeeModel;
import com.notificationservices.domains.EventDateTimeModel;
import com.notificationservices.domains.EventModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneralEventMapper {
    EventModel toEventModel(Event event);

    EventAttendee toEvent(AttendeeModel attendeeModel);

    AttendeeModel toEventAttendeeModel(EventAttendee eventAttendee);

    default EventDateTimeModel toEventDateTimeModel(EventDateTime eventDateTime) {
        EventDateTimeModel eventDateTimeModel = new EventDateTimeModel();
        if (eventDateTime.getDateTime() != null)
            eventDateTimeModel.setDateTime(eventDateTime.getDateTime().toStringRfc3339());
        eventDateTimeModel.setTimeZone(eventDateTime.getTimeZone());
        return eventDateTimeModel;
    }


}
