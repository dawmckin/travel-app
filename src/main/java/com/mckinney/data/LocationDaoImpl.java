package com.mckinney.data;

import com.mckinney.models.Country;
import com.mckinney.models.Location;
import com.mckinney.services.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDaoImpl implements LocationDao{

    private ConnectionService connectionService;

    @Override
    public List<Location> getLocationsByCountry(Country country) {
        connectionService = new ConnectionService();
        String sql = "select * from tourist_location where country_id = ?";

        try(Connection connection = connectionService.getConnection();) {

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, country.getCountryId());
            ResultSet rs = pstmt.executeQuery();

            List<Location> locationList = new ArrayList<>();

            while(rs.next()) {
                Location location = new Location();
                location.setLocationId(rs.getInt("location_id"));
                location.setLocationName(rs.getString("location_name"));
                location.setAddress(rs.getString("address"));
                location.setCityName(rs.getString("city"));
                location.setCountry(country);
                locationList.add(location);

            }
            return locationList;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public Location getLocationById(int locationId) {
        return null;
    }

    @Override
    public Location getLocationByName(String name) {
        return null;
    }

    @Override
    public void deleteLocation(Location location) {

    }

    @Override
    public Location createLocation(Location location) {
        return null;
    }

    @Override
    public Location updateLocation(Location location) {
        return null;
    }
}
