package com.hotel.hotelManagement.controllers;

import com.hotel.hotelManagement.exceptions.GuestDetailsException;
import com.hotel.hotelManagement.models.GuestDetails;
import com.hotel.hotelManagement.services.GuestDetailsService;
import com.hotel.hotelManagement.utils.GenerateErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by darshansapaliga on 4/2/18.
 */
@RestController
public class GuestController {

    @Autowired
    private GuestDetailsService guestDetailsService;

    @Autowired
    private GenerateErrorResponse generateErrorResponse;


    @RequestMapping(value="/addGuestDetails", method = RequestMethod.POST)
    public ResponseEntity addGuestDetails(@RequestBody GuestDetails guestData) {

        try {
            //call to the service layer
            GuestDetails guestDetails = guestDetailsService.addGuestDetails(guestData);

            return new ResponseEntity(guestDetails, HttpStatus.CREATED);

        } catch(GuestDetailsException ex) {
            return new ResponseEntity(generateErrorResponse.generateErrorReponse("404", ex.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(generateErrorResponse.generateErrorReponse("404", "Internal Server Error"), HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public ResponseEntity Hello() {

        return new ResponseEntity("Hello", HttpStatus.OK);

    }



}
