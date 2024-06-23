package com.routefare.service.routefare.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.routefare.service.routefare.domain.address.AddressRequest;
import com.routefare.service.routefare.domain.address.AddressResponse;
import com.routefare.service.routefare.mappers.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AddressService {
    private static final Logger log = LoggerFactory.getLogger(AddressService.class);

    @Value("${apiGooglePlacesKey}")
    private String api_key;

    @Value("${apiAutocompleteBasepath}")
    private String autocompleteBasepath;

    @Autowired
    private AddressMapper addressMapper;

    public AddressResponse getAllMatchingAddressesForRequest(@NotNull AddressRequest addressRequest) {
        log.info("Handling getAllMatchingAddressesForRequest for input text: {}", addressRequest);
        RestTemplate restTemplate = new RestTemplate();
        // Set up the headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Goog-Api-Key", api_key); // Use the correct header name as per the API documentation
        headers.set("Content-Type", "application/json");
        String reqJSON = addressMapper.domainToJSON(addressRequest);

        // Create the HttpEntity with the headers
        HttpEntity<String> entity = new HttpEntity<>(reqJSON, headers);

        // Make the request with the headers
        ResponseEntity<AddressResponse> response = restTemplate.exchange(
                autocompleteBasepath, HttpMethod.POST, entity, AddressResponse.class);
        log.info("{}", response.getBody());
        return response.getBody();
    }
}
