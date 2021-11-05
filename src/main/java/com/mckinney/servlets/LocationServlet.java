package com.mckinney.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mckinney.models.Location;
import com.mckinney.services.LocationService;
import com.mckinney.services.LocationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.util.ArrayList;

public class LocationServlet extends HttpServlet {

    private LocationServiceImpl locationService = new LocationServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("GET request to /locations");
        String countryName = req.getParameter("countryName");
        ArrayList<Location> locationList = locationService.lookUpLocationsByCountryName(countryName);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(locationList);

        res.getWriter().write(json);
        res.setStatus(200);
    }

}
