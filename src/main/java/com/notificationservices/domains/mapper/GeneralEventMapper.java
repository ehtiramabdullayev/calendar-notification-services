package com.notificationservices.domains.mapper;

/**
 * @author Ehtiram_Abdullayev on 18.12.2018
 * @project notificationservices
 */
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.notificationservices.domains.AttendeeModel;
import com.notificationservices.domains.EventModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GeneralEventMapper  {
    GeneralEventMapper MAPPER = Mappers.getMapper(GeneralEventMapper.class);

    EventModel toEventModel(Event event);

    AttendeeModel toEventAttendee(EventAttendee eventAttendee);

}
