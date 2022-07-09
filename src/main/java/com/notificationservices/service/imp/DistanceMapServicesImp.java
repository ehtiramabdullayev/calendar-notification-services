package com.notificationservices.service.imp;

import com.notificationservices.domains.distance.DistanceResponse;
import com.notificationservices.service.DistanceMapServices;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Ehtiram_Abdullayev on 18.12.2018
 * @project notificationservices
 */
@Service
public class DistanceMapServicesImp implements DistanceMapServices {
    private static final String API_KEY = "";
    private static final String BASE_URI = "https://maps.googleapis.com/maps/api/distancematrix/json?";

    private final RestTemplate restTemplate;

    public DistanceMapServicesImp(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public DistanceResponse distanceResponse(String origins,String destinations,String mode) {
        String language = "en-En";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
//        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URI)
                .queryParam("origins", origins)
                .queryParam("destinations",destinations)
                .queryParam("mode",mode)
                .queryParam("language",language)
                .queryParam("key",API_KEY);


        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        HttpEntity<DistanceResponse> response = restTemplate.exchange(
                componentsBuilder.toUriString(),
                HttpMethod.GET,
                entity,
                DistanceResponse.class
        );
        return response.getBody();

    }

}
