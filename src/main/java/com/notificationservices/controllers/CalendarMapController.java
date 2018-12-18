package com.notificationservices.controllers;

import com.notificationservices.domains.EventMapResult;
import com.notificationservices.domains.EventModel;
import com.notificationservices.domains.distance.DistanceResponse;
import com.notificationservices.service.DistanceMapServices;
import com.notificationservices.service.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author Ehtiram_Abdullayev on 18.12.2018
 * @project notificationservices
 */
@RestController
public class CalendarMapController {

    @Autowired
    private DistanceMapServices distanceMapServicesImp;

    @Autowired
    private EventServices eventServices;

    @GetMapping(value = "/getDistanceOfGivenEventById")
    public EventMapResult getDistanceOfGivenEvent(@RequestParam("eventId") String eventId,
                                                  @RequestParam(value = "origins") String origins,
                                                  @RequestParam(value = "mode") String mode) throws GeneralSecurityException, IOException {
        EventMapResult eventMapResult = new EventMapResult();

        EventModel foundEvent = eventServices.getClientEvents().stream().findFirst().filter(eventModel -> eventModel.getId().startsWith(eventId)).get();
        DistanceResponse distanceResponse = distanceMapServicesImp.distanceResponse(origins, foundEvent.getLocation(), mode);
        eventMapResult.setDistanceResponse(distanceResponse);
        eventMapResult.setSummary(foundEvent.getSummary());
        eventMapResult.setDescription(foundEvent.getDescription());
        eventMapResult.setLocation(foundEvent.getLocation());
        eventMapResult.setId(foundEvent.getId());

        return eventMapResult;
    }

}
