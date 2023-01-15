package dev.mckinney.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.mckinney.model.Country;
import dev.mckinney.service.CountryService;
import dev.mckinney.service.CountryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CountryServlet extends HttpServlet  {

    private CountryService countryService = new CountryServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST request to /countries");

        String countryName = req.getParameter("countryName");
        String abbreviation = req.getParameter("abbreviation");

        Country country = new Country();

        country.setAbbreviation(abbreviation);
        country.setCountryName(countryName);

        countryService.addCountry(country);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET request to /countries");

        List<Country> countries = countryService.getAllCountries();
        ObjectMapper objectMapper = new ObjectMapper();

        resp.getWriter().write(objectMapper.writeValueAsString(countries));

    }
}
