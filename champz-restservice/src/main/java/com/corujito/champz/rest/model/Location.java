package com.corujito.champz.rest.model;

public class Location {

    private Integer country;
    private Integer state;
    private Integer city;

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Location withCountry(Integer country) {
        setCountry(country);
        return this;
    }

    public Location withState(Integer state) {
        setState(state);
        return this;
    }

    public Location withCity(Integer city) {
        setCity(city);
        return this;
    }
}
