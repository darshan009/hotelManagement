package com.hotel.hotelManagement.repositories;

import com.hotel.hotelManagement.models.GuestDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by darshansapaliga on 4/2/18.
 */
@Repository
public interface GuestDetailsRepository extends CrudRepository<GuestDetails, Integer> {
}
