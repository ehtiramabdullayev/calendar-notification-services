package com.notificationservices.service;

import com.notificationservices.domains.distance.DistanceResponse;

/**
 * @author Ehtiram_Abdullayev on 18.12.2018
 * @project notificationservices
 */
public interface DistanceMapServices {
    DistanceResponse distanceResponse(String origins, String destinations, String mode);
}
