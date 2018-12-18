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
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeneralEventMapper {
    GeneralEventMapper MAPPER = Mappers.getMapper(GeneralEventMapper.class);

    EventModel toEventModel(Event event);

    AttendeeModel toEventAttendeeModel(EventAttendee eventAttendee);

    default EventDateTimeModel toEventDateTimeModel(EventDateTime eventDateTime) {

        EventDateTimeModel eventDateTimeModel = new EventDateTimeModel();
        if (eventDateTime.getDateTime() != null)
            eventDateTimeModel.setDateTime(eventDateTime.getDateTime().toStringRfc3339());
        eventDateTimeModel.setTimeZone(eventDateTime.getTimeZone());
        return eventDateTimeModel;
    }
}
