package dev.mckinney.model;


import javax.persistence.*;

@Entity
@Table(name = "tourist_location", schema = "travel_app")
public class Location {

    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "address")
    private String address;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int locationId;

    public Location() {
        super();
    }

    public Location(Country country, String locationName, String cityName, String address, int locationId) {
        super();
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
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        if (getLocationId() != location.getLocationId()) return false;
        if (getCountry() != null ? !getCountry().equals(location.getCountry()) : location.getCountry() != null)
            return false;
        if (getLocationName() != null ? !getLocationName().equals(location.getLocationName()) : location.getLocationName() != null)
            return false;
        if (getCityName() != null ? !getCityName().equals(location.getCityName()) : location.getCityName() != null)
            return false;
        return getAddress() != null ? getAddress().equals(location.getAddress()) : location.getAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = getCountry() != null ? getCountry().hashCode() : 0;
        result = 31 * result + (getLocationName() != null ? getLocationName().hashCode() : 0);
        result = 31 * result + (getCityName() != null ? getCityName().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + getLocationId();
        return result;
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
