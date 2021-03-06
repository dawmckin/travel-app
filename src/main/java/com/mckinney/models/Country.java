package com.mckinney.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "country", schema = "public")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "abbreviation")
    private String abbreviation;

    public Country() {
    }

    public Country(int id, String name, String abbreviation) {
        this.countryId = id;
        this.countryName = name;
        this.abbreviation = abbreviation;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int id) {
        this.countryId = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countryId == country.countryId && Objects.equals(countryName, country.countryName) && Objects.equals(abbreviation, country.abbreviation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countryName, abbreviation);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + countryId +
                ", name='" + countryName + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                '}';
    }
}
