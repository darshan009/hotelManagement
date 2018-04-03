package com.hotel.hotelManagement.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by darshansapaliga on 4/2/18.
 */
@RestController
public class GuestController {


    @RequestMapping(value="/addGuestDetails", method = RequestMethod.POST)
    public ResponseEntity addGuestDetails(@RequestBody Map<String, Object> guestData) {

        try {
            //validations


            //call to the service layer
        } catch(Exception ex) {

        }


        return null;

    }

}
