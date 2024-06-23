package com.routefare.service.routefare.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.routefare.service.routefare.domain.address.AddressRequest;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper {
    public String domainToJSON(AddressRequest addressRequest) {
        String reqJSON = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Serialize the user object to JSON
            reqJSON = objectMapper.writeValueAsString(addressRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return reqJSON;
    }
}
