package com.github.xrapalexandra.model;

import java.util.Objects;

public class Address {

    private String city;
    private String street;
    private String building;

    public Address() {
    }

    public Address(String city, String street, String building) {
        this.city = city;
        this.street = street;
        this.building = building;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @Override
    public String toString() {
        return building + '\'' +
                " " + street + '\'' +
                " " + city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return city.equalsIgnoreCase(address.city) &&
                street.equalsIgnoreCase(address.street) &&
                building.equalsIgnoreCase(address.building);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, building);
    }
}
