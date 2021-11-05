package com.mckinney.services;

import com.mckinney.data.*;
import com.mckinney.models.Country;
import com.mckinney.models.Location;

import java.util.List;

public class LocationServiceImpl implements LocationService{

    private CountryDao countryDao = new CountryDaoHibernate();
    private LocationDao locationDao = new LocationDaoHibernate();

    @Override
    public List<Location> lookUpLocationsByCountryName(String countryName) {
        Country country = countryDao.getCountryByName(countryName);
        return locationDao.getLocationsByCountry(country);
    }
}
