package com.hotel.hotelManagement.models;

import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date arrival;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date departure;

    public GuestDetails() {}


    public GuestDetails(String name, String email, Date arrival, Date departure) {
        this.name =  name;
        this.email = email;
        this.arrival = arrival;
        this.departure = departure;
    }



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
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }


}
