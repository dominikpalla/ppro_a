package com.example.demo.service;

import com.example.demo.model.Driver;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class DriverServiceImpl implements DriverService{

    ArrayList<Driver> drivers = new ArrayList<>();

    @Override
    public ArrayList<Driver> getAllDrivers() {
        return drivers;
    }

    @Override
    public Driver getDriverById(int id) {
        if(id > -1 && id < drivers.size()){
            return drivers.get(id);
        }
        return null;
    }

    @Override
    public void deleteDriverById(int id) {
        if(id > -1 && id < drivers.size()){
            drivers.remove(id);
        }
    }

    @Override
    public void saveDriver(Driver Driver) {
        if(Driver.getId() > -1 && Driver.getId() < drivers.size()){
            drivers.remove(Driver.getId());
        }
        drivers.add(Driver);
    }


}
