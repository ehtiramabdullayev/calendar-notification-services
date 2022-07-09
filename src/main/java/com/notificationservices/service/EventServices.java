package com.notificationservices.service;

import com.notificationservices.domains.EventModel;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 17.12.2018
 * @project notificationservices
 */
public interface EventServices {
    EventModel createEvent(EventModel eventInput) throws GeneralSecurityException, IOException;
    List<EventModel> getClientEvents() throws GeneralSecurityException, IOException;
}
