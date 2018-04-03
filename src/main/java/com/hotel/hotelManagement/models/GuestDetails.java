package com.hotel.hotelManagement.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darshansapaliga on 4/2/18.
 */
@Entity
public class GuestDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    //perform validations here
    private String name;
    private String email;
    private Date Arrival;
    private Date Departure;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getArrival() {
        return Arrival;
    }

    public void setArrival(Date arrival) {
        Arrival = arrival;
    }

    public Date getDeparture() {
        return Departure;
    }

    public void setDeparture(Date departure) {
        Departure = departure;
    }


}
