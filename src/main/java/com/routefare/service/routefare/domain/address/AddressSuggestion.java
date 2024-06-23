package com.routefare.service.routefare.domain.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressSuggestion {

    @JsonProperty("placePrediction")
    @NotNull
    private PlacePrediction placePrediction;

}
