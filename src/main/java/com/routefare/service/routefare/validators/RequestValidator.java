package com.routefare.service.routefare.validators;

import com.routefare.service.routefare.domain.address.AddressRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RequestValidator {

    public void validateAddressRequest(AddressRequest addressRequest) {
        if(addressRequest.getInput() == null){
            throw new RuntimeException("Input text is empty.");
        }
    }
}
