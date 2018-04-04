package com.hotel.hotelManagement.controllers;

import com.hotel.hotelManagement.exceptions.ConfigException;
import com.hotel.hotelManagement.models.Config;
import com.hotel.hotelManagement.services.ConfigService;
import com.hotel.hotelManagement.utils.GenerateErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  Configuration controller:
 *  set up configuration elements like Number of available rooms in hotel,
 *  overbooking limit
 */
@RestController
public class ConfigController {

    @Autowired
    private GenerateErrorResponse generateErrorResponse;

    @Autowired
    private ConfigService configService;


    /*
     *  configuration setup method - add/update
     *  @Params: List of Config model objects
     *  Accepted values for current system : overbooking limit(%), number of rooms
    */
    @RequestMapping(value = "/bookingConfig", method = RequestMethod.POST)
    public ResponseEntity bookingConfig(@RequestBody List<Config> config) {
        try {

            List<Config> configList = configService.bookingConfig(config);
            return new ResponseEntity(configList, HttpStatus.CREATED);

        } catch(ConfigException ce) {
            return new ResponseEntity(generateErrorResponse.generateErrorReponse("400", ce.getMessage()), HttpStatus.BAD_REQUEST);
        } catch(Exception e) {
            return new ResponseEntity(generateErrorResponse.generateErrorReponse("500", "Internal Server Error"), HttpStatus.BAD_REQUEST);
        }

    }


}
