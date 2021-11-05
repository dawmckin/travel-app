package com.mckinney.data;

import com.mckinney.models.Country;
import com.mckinney.services.ConnectionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryDaoImpl implements CountryDao{

    private ConnectionService connectionService;

    @Override
    public Country getCountryByName(String countryName) {
        connectionService = new ConnectionService();
        String sql = "select * from country where country_name = ?";

        try(Connection connection = connectionService.getConnection();) {

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, countryName);
            ResultSet rs = pstmt.executeQuery();

            Country country = new Country();

            while(rs.next()) {
                country.setCountryName(rs.getString("country_name"));
                country.setCountryId(rs.getInt("country_id"));
                country.setAbbreviation(rs.getString("abbreviation"));
            }

            return country;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

}
