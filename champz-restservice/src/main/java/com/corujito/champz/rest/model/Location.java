package com.corujito.champz.rest.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Location rhs = (Location) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(country, rhs.country)
                .append(state, rhs.state)
                .append(city, rhs.city)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(country)
                .append(state)
                .append(city)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("country", this.country)
                .append("state", this.state)
                .append("city", this.city)
                .toString();
    }
}
