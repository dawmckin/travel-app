package dev.mckinney.data;

import dev.mckinney.model.Country;

import java.util.List;

public interface CountryDao {

    public Country getCountryByName(String countryName);

    public List<Country> getAllCountries();

    public Country createCountry(Country country);
}
