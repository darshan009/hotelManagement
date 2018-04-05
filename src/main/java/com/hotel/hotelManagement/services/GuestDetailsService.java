package com.hotel.hotelManagement.services;

import com.hotel.hotelManagement.exceptions.GuestDetailsException;
import com.hotel.hotelManagement.models.Config;
import com.hotel.hotelManagement.models.GuestDetails;
import com.hotel.hotelManagement.repositories.ConfigRepository;
import com.hotel.hotelManagement.repositories.GuestDetailsRepository;
import com.hotel.hotelManagement.utils.GenerateDateListInRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

/**
 * Guest Details service layer
 * This class contains all the guest related operation business logic
 */
@Service
public class GuestDetailsService {

    @Autowired
    private GuestDetailsRepository guestDetailsRepository;

    @Autowired
    private ConfigRepository configRepository;

    @Autowired
    private GenerateDateListInRange generateDateListInRange;


    /*
     *  method for making a booking - business logic
     *  @Params: GuestDetails model object
     *  Accepted values in model: guestName, guestEmail, arrival date, departure date
    */
    public GuestDetails addGuestDetails(GuestDetails guestDetails) throws GuestDetailsException, ParseException {

        //check for the entered input should not be null
        if (guestDetails.getGuestName() == null || guestDetails.getGuestName().equals(""))
            throw new GuestDetailsException("Guest Name cannot be empty");
        if (guestDetails.getGuestEmail() == null || guestDetails.getGuestEmail().equals(""))
            throw new GuestDetailsException("Guest Email cannot be empty");
        if (guestDetails.getArrival() == null)
            throw new GuestDetailsException("Guest Arrival Date cannot be empty");
        if (guestDetails.getDeparture() == null)
            throw new GuestDetailsException("Guest Departure Date cannot be empty");

        //if arrival date before departure date
        if(guestDetails.getArrival().compareTo(guestDetails.getDeparture()) > 0)
            throw new GuestDetailsException("Arrival date cannot be after departure date");


        //before saving, check for the number of bookings for all the dates of their stay

        //generate list all the dates between their stay
        List<Date> allDates = generateDateListInRange.getDaysBetweenDates(guestDetails.getArrival(), guestDetails.getDeparture());

        //get rooms and overbooking from config table
        Config room = configRepository.findByConfigName("rooms");
        Config overbooking = configRepository.findByConfigName("overbooking");

        if(room == null || overbooking == null)
            throw new GuestDetailsException("No configuration setup. Unable to make a booking");
        int rooms = room.getConfigNumber();
        int overbookingLimit = ((overbooking.getConfigNumber() * rooms) / 100) + rooms;

        //check if bookings for all the dates booked are with overbooking limit
        for (Date date : allDates) {
            long count = guestDetailsRepository.countByArrivalLessThanEqualAndDepartureGreaterThanEqual(date, date);

            if (count > overbookingLimit) {
                throw new GuestDetailsException("Booking limit reached for " + date);
            }
        }

        guestDetailsRepository.save(guestDetails);

        return guestDetails;
    }


}
