package com.notificationservices.domains.distance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

/**
 * @author Ehtiram_Abdullayev on 18.12.2018
 * @project notificationservices
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DistanceResponse {
    private String status;

    @JsonProperty("origin_addresses")
    private String[] originAddresses;

    @JsonProperty("destination_addresses")
    private String[] destinationAddresses;



    private Rows[] rows;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getOriginAddresses() {
        return originAddresses;
    }

    public void setOriginAddresses(String[] originAddresses) {
        this.originAddresses = originAddresses;
    }

    public String[] getDestinationAddresses() {
        return destinationAddresses;
    }

    public void setDestinationAddresses(String[] destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public Rows[] getRows() {
        return rows;
    }

    public void setRows(Rows[] rows) {
        this.rows = rows;
    }


}
