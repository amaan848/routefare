package com.routefare.service.routefare.domain.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlacePrediction {

    @JsonProperty("place")
    private String place;

    @JsonProperty("placeId")
    private String placeId;

    @JsonProperty("text")
    private AddressText addressText;

}
