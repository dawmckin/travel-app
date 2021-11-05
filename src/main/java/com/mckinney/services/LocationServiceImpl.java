package com.mckinney.services;

import com.mckinney.data.CountryDaoImpl;
import com.mckinney.data.LocationDaoImpl;
import com.mckinney.models.Country;
import com.mckinney.models.Location;

import java.util.ArrayList;

public class LocationServiceImpl implements LocationService{

    private CountryDaoImpl countryDao = new CountryDaoImpl();
    private LocationDaoImpl locationDao = new LocationDaoImpl();

    @Override
    public ArrayList<Location> lookUpLocationsByCountryName(String countryName) {
        Country country = countryDao.getCountryByName(countryName);
        return locationDao.getLocationsByCountry(country);
    }
}
