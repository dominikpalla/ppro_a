package com.example.demo.service;

import com.example.demo.model.Driver;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public interface DriverService {

    ArrayList<Driver> getAllDrivers();
    Driver getDriverById(int id);
    void deleteDriverById(int id);
    void saveDriver(Driver Driver);
}
