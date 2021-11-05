package com.mckinney.services;

import com.mckinney.models.Location;

import java.util.List;

public interface LocationService {

    public List<Location> lookUpLocationsByCountryName(String countryName);

}
