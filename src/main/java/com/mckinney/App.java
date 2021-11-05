package com.mckinney;

import com.mckinney.models.Location;
import com.mckinney.services.LocationServiceImpl;

import java.util.List;

public class App {

    public static void main(String[] args) {
        LocationServiceImpl locationService = new LocationServiceImpl();
        List<Location> locations = locationService.lookUpLocationsByCountryName("Canada");

        for(int i = 0; i < locations.size(); i++) {
            System.out.println(locations.get(i).toString());
        }
    }
}
