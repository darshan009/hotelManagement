package com.hotel.hotelManagement.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by darshansapaliga on 4/2/18.
 */
@Component
public class GenerateErrorResponse {

    public Map<String, String> generateErrorReponse(String errorCode, String error) {
        HashMap<String, String> errorMsg = new HashMap<String, String>();
        errorMsg.put(errorCode, error);
        return errorMsg;
    }

}
