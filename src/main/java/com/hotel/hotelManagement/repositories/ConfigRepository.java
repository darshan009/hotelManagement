package com.hotel.hotelManagement.repositories;

import com.hotel.hotelManagement.models.Config;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by darshansapaliga on 4/2/18.
 */
@Repository
public interface ConfigRepository extends CrudRepository<Config, Integer> {

    Config findByConfigName(String name);

}
