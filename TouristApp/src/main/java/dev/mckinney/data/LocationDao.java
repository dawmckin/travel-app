package dev.mckinney.data;

import dev.mckinney.model.Country;
import dev.mckinney.model.Location;

import java.util.List;

public interface LocationDao {

    public List<Location> getAllLocations();

    public List<Location> getLocationsByCountry(Country country);

    public Location getLocationById(int locationId);

    public Location getLocationByName(String name);

    public void deleteLocation(Location location);

    public Location createLocation(Location location);

    public Location updateLocation(Location location);
}
