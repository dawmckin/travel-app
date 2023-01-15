package dev.mckinney;

import dev.mckinney.data.CountryDao;
import dev.mckinney.data.CountryDaoImpl;
import dev.mckinney.model.Country;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CountryDao countryDao = new CountryDaoImpl();

        List<Country> countries = countryDao.getAllCountries();
        countries.forEach(c -> System.out.println(c));

//        Country country = countryDao.getCountryByName("Germany");
//        System.out.println(country);
    }
}