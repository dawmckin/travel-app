package dev.mckinney.service;

import dev.mckinney.model.Location;

import java.util.List;

public interface LocationService {

    public List<Location> lookUpLocationsByCountryName(String countryName);

    public List<Location> getAllLocations();
}
