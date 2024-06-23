package com.routefare.service.routefare.controllers;

import com.routefare.service.routefare.domain.address.AddressRequest;
import com.routefare.service.routefare.domain.address.AddressResponse;
import com.routefare.service.routefare.service.AddressService;
import com.routefare.service.routefare.validators.RequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    private static final Logger log = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    AddressService addressService;

    @Autowired
    RequestValidator requestValidator;

    @PostMapping("/autocomplete")
    public ResponseEntity<AddressResponse> getAddressesForInputText(@RequestBody AddressRequest addressRequest) {
        log.info("handling getAddressesForInputText request for input :{}", addressRequest.getInput());
        requestValidator.validateAddressRequest(addressRequest);
        AddressResponse addressResponse = addressService.getAllMatchingAddressesForRequest(addressRequest);
        log.info("{}", addressResponse);
        return new ResponseEntity<>(addressResponse, HttpStatus.OK);
    }
}
