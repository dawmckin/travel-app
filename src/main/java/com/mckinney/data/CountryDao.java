package com.mckinney.data;

import com.mckinney.models.Country;

public interface CountryDao {

    public Country getCountryByName(String name);

}
