package com.mckinney.services;

import com.mckinney.models.Location;

import java.util.ArrayList;

public interface LocationService {

    public ArrayList<Location> lookUpLocationsByCountryName(String countryName);

}
