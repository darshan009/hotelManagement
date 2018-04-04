package com.hotel.hotelManagement.services;

import com.hotel.hotelManagement.exceptions.ConfigException;
import com.hotel.hotelManagement.models.Config;
import com.hotel.hotelManagement.repositories.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by darshansapaliga on 4/2/18.
 */
@Service
@Transactional
public class ConfigService {

    @Autowired
    private ConfigRepository configRepository;


    /*
     *  method for setting up booking configuration - add/update
     *  @Params: List of Config model object
     *  Accepted values in system for now: overbooking limit(%), number of rooms
    */
    public List<Config> bookingConfig(List<Config> configList) throws ConfigException {

        for(Config config : configList) {

            //check for empty fields
            if(config.getConfigName() == null || config.getConfigName().equals(""))
                throw new ConfigException("Configuration name cannot be empty");
            if(config.getConfigNumber() == 0)
                throw new ConfigException("Configuration number cannot be empty");

            //add one by one
            Config configToUpdate = configRepository.findByConfigName(config.getConfigName());

            //if configToUpdate is not null then update else create
            if(configToUpdate != null) {
                configToUpdate.setConfigName(config.getConfigName());
                configToUpdate.setConfigNumber(config.getConfigNumber());
                configRepository.save(configToUpdate);
            } else {
                configRepository.save(config);
            }

        }
        return configList;
    }


}
