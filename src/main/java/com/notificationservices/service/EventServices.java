package com.notificationservices.service;



import com.notificationservices.domains.EventInputModel;
import com.notificationservices.domains.EventOutputModel;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * @author Ehtiram_Abdullayev on 17.12.2018
 * @project notificationservices
 */
public interface EventServices {
    public String createEvent(EventInputModel eventInput) throws GeneralSecurityException, IOException;
    public List<EventOutputModel> getClientEvents() throws GeneralSecurityException, IOException;
}
