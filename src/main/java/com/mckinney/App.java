package com.mckinney;

import com.mckinney.data.CountryDaoImpl;
import com.mckinney.data.LocationDaoImpl;
import com.mckinney.models.Country;
import com.mckinney.models.Location;
import com.mckinney.services.ConnectionService;
import com.mckinney.services.LocationService;
import com.mckinney.services.LocationServiceImpl;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        LocationServiceImpl locationService = new LocationServiceImpl();
        ArrayList<Location> locations = locationService.lookUpLocationsByCountryName("Canada");

        for(int i = 0; i < locations.size(); i++) {
            System.out.println(locations.get(i).toString());
        }
    }
}
