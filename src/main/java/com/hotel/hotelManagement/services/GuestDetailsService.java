package com.hotel.hotelManagement.services;

import com.hotel.hotelManagement.config.BookingConfig;
import com.hotel.hotelManagement.exceptions.GuestDetailsException;
import com.hotel.hotelManagement.models.GuestDetails;
import com.hotel.hotelManagement.repositories.GuestDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by darshansapaliga on 4/2/18.
 */
@Service
public class GuestDetailsService {

    @Autowired
    private GuestDetailsRepository guestDetailsRepository;

    @Autowired
    private BookingConfig bookingConfig;

    public GuestDetails addGuestDetails(GuestDetails guestDetails) throws GuestDetailsException {

        //check for the entered input should not be null
        if(guestDetails.getName() == null || guestDetails.getName().equals(""))
            throw new GuestDetailsException("Guest Name cannot be empty");
        if(guestDetails.getEmail() == null || guestDetails.getEmail().equals(""))
            throw new GuestDetailsException("Guest Email cannot be empty");
        if(guestDetails.getArrival() == null)
            throw new GuestDetailsException("Guest Arrival Date cannot be empty");
        if(guestDetails.getDeparture() == null)
            throw new GuestDetailsException("Guest Departure Date cannot be empty");


        //before saving, check for the number of bookings for that day
        //check if arrival date and departure date lies in between any of the dates
        guestDetailsRepository.save(guestDetails);


        return guestDetails;
    }

}
