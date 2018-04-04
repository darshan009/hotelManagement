package com.hotel.hotelManagement.utils;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by darshansapaliga on 4/4/18.
 */
@Component
public class GenerateDateListInRange {

    /*
     *  method for generating a list of dates in a given range
     *  @Params: Date start to Date end
    */
    public static List<Date> getDaysBetweenDates(Date startdate, Date enddate) {
        List<Date> dates = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startdate);

        while (calendar.getTime().before(enddate))
        {
            Date result = calendar.getTime();
            dates.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        dates.add(enddate);
        return dates;
    }

}
