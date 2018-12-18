package com.notificationservices.controllers;

import com.notificationservices.domains.EventModel;
import com.notificationservices.service.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 17.12.2018
 * @project notificationservices
 */
@RestController
public class EventController {

    @Autowired
    private EventServices eventServices;


    @GetMapping(value = "/getAllEvents")
    public List<EventModel> getAllEvents() throws GeneralSecurityException, IOException {
        return eventServices.getClientEvents();
    }

    @GetMapping(value = "/getEventById")
    public EventModel getEventById(@RequestParam("eventId") String eventId) throws GeneralSecurityException, IOException {
        return eventServices.getClientEvents().stream().findFirst().filter(eventModel -> eventModel.getId().equals(eventId)).get();
    }


    @PostMapping(value = "/createEvent")
    public EventModel createEvent(@RequestBody EventModel eventModel) throws GeneralSecurityException, IOException {
        return eventServices.createEvent(eventModel);
    }

}
