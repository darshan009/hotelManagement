package com.hotel.hotelManagement.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by darshansapaliga on 4/2/18.
 */
@Entity
@Table(name = "guestDetails")
public class GuestDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer guestId;

    //perform validations here
    private String guestName;
    private String guestEmail;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "PST")
    private Date arrival;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "PST")
    private Date departure;



    public GuestDetails() {}

    public GuestDetails(String guestName, String guestEmail,Date arrival, Date departure) {
        this.guestEmail = guestEmail;
        this.guestName = guestName;
        this.arrival = arrival;
        this.departure = departure;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
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
