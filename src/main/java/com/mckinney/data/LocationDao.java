package com.mckinney.data;

import com.mckinney.models.Country;
import com.mckinney.models.Location;

import java.util.ArrayList;

public interface LocationDao {

    public ArrayList<Location> getLocationsByCountry(Country country);

}
