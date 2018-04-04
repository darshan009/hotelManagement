package com.hotel.hotelManagement.models;

import javax.persistence.*;

/**
 * Created by darshansapaliga on 4/2/18.
 */
@Entity
@Table(name = "systemConfig")
public class Config {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int configId;

    private int configNumber;

    @Column(unique = true)
    private String configName;



    public Config() {}

    public int getConfigId() {
        return configId;
    }

    public int getConfigNumber() {
        return configNumber;
    }

    public void setConfigNumber(int configNumber) {
        this.configNumber = configNumber;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }
}
