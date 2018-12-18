package com.notificationservices.controllers;

import com.notificationservices.domains.distance.DistanceResponse;
import com.notificationservices.service.DistanceMapServices;
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
public class DistanceMatrixController {
    @Autowired
    private DistanceMapServices distanceMapServicesImp;


    @GetMapping(value = "/getDistance")
    public DistanceResponse getResponse(@RequestParam(value = "origins") String origins,
                                        @RequestParam(value = "destinations") String destinations,
                                        @RequestParam(value = "mode") String mode) throws GeneralSecurityException, IOException {
        return distanceMapServicesImp.distanceResponse(origins, destinations, mode);
    }

}
