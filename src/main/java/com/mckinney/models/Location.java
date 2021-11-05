package com.mckinney.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tourist_location")
public class Location {

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "city")
    private String cityName;

    @Column(name = "address")
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int locationId;

    public Location() {
    }

    public Location(Country country, String locationName, String cityName, String address, int locationId) {
        this.country = country;
        this.locationName = locationName;
        this.cityName = cityName;
        this.address = address;
        this.locationId = locationId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return locationId == location.locationId && Objects.equals(country, location.country) && Objects.equals(locationName, location.locationName) && Objects.equals(cityName, location.cityName) && Objects.equals(address, location.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, locationName, cityName, address, locationId);
    }

    @Override
    public String toString() {
        return "Location{" +
                "country=" + country +
                ", locationName='" + locationName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", address='" + address + '\'' +
                ", locationId=" + locationId +
                '}';
    }
}
