package dev.mckinney.service;

import dev.mckinney.model.Country;

import java.util.List;

public interface CountryService {

    public List<Country> getAllCountries();

    public Country addCountry(Country country);
}
