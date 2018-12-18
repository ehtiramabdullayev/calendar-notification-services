package com.notificationservices.config;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;


/**
 * @author Ehtiram_Abdullayev on 17.12.2018
 * @project notificationservices
 */
public class Utils {
    private Utils() {
    }

    public static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
    public static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

}
