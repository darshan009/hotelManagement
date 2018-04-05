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
 * Guest Details controller
 * contains all guest details related operations
 * CRUD operations on guest details
 */
@RestController
public class GuestController {

    @Autowired
    private GuestDetailsService guestDetailsService;

    @Autowired
    private GenerateErrorResponse generateErrorResponse;


    /*
     *  method for making a booking
     *  @Params: GuestDetails model object
     *  Accepted values in model: guestName, guestEmail, arrival date, departure date
    */
    @RequestMapping(value="/addGuestDetails", method = RequestMethod.POST)
    public ResponseEntity addGuestDetails(@RequestBody GuestDetails guestData) {

        try {

            GuestDetails guestDetails = guestDetailsService.addGuestDetails(guestData);

            return new ResponseEntity(guestDetails, HttpStatus.CREATED);

        } catch(GuestDetailsException ex) {
            return new ResponseEntity(generateErrorResponse.generateErrorReponse("404", ex.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity(generateErrorResponse.generateErrorReponse("500", e.getMessage()), HttpStatus.NOT_FOUND);
        }

    }


    /*
      *  method for docker testing - display hello world
     */
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public ResponseEntity helloWorld() {
            return new ResponseEntity("Hello World!", HttpStatus.CREATED);
    }


}
