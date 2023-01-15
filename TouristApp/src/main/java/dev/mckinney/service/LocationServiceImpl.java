package dev.mckinney.service;

import dev.mckinney.data.CountryDao;
import dev.mckinney.data.CountryDaoImpl;
import dev.mckinney.data.LocationDao;
import dev.mckinney.data.LocationDaoImpl;
import dev.mckinney.model.Country;
import dev.mckinney.model.Location;

import java.util.List;

public class LocationServiceImpl implements LocationService{

    private LocationDao locationDao = new LocationDaoImpl();
    private CountryDao countryDao = new CountryDaoImpl();

    @Override
    public List<Location> lookUpLocationsByCountryName(String countryName) {
        Country country = countryDao.getCountryByName(countryName);
        return locationDao.getLocationsByCountry(country);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationDao.getAllLocations();
    }
}
