package dev.mckinney.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.mckinney.model.Location;
import dev.mckinney.service.LocationService;
import dev.mckinney.service.LocationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LocationServlet extends HttpServlet {

    private LocationService locationService = new LocationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET request to /locations");

        String countryName = req.getParameter("countryName");
        List<Location> locations = locationService.lookUpLocationsByCountryName(countryName);
        ObjectMapper objectMapper = new ObjectMapper();
        resp.getWriter().write(objectMapper.writeValueAsString(locations));
        resp.setStatus(200);
    }
}
