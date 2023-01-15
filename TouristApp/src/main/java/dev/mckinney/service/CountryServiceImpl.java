package dev.mckinney.service;

import dev.mckinney.data.CountryDao;
import dev.mckinney.data.CountryDaoImpl;
import dev.mckinney.model.Country;

import java.util.List;

public class CountryServiceImpl implements CountryService {

    private CountryDao countryDao = new CountryDaoImpl();

    @Override
    public List<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    @Override
    public Country addCountry(Country country) {
        return countryDao.createCountry(country);
    }
}
