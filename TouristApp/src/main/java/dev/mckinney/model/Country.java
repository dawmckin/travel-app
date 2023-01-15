package dev.mckinney.model;


import javax.persistence.*;

@Entity
@Table(name = "country", schema = "travel_app")
public class Country {

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;

    public Country() {
        super();
    }

    public Country(String countryName, String abbreviation, int countryId) {
        super();
        this.countryName = countryName;
        this.abbreviation = abbreviation;
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (getCountryId() != country.getCountryId()) return false;
        if (getCountryName() != null ? !getCountryName().equals(country.getCountryName()) : country.getCountryName() != null)
            return false;
        return getAbbreviation() != null ? getAbbreviation().equals(country.getAbbreviation()) : country.getAbbreviation() == null;
    }

    @Override
    public int hashCode() {
        int result = getCountryName() != null ? getCountryName().hashCode() : 0;
        result = 31 * result + (getAbbreviation() != null ? getAbbreviation().hashCode() : 0);
        result = 31 * result + getCountryId();
        return result;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
