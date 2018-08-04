package com.bingoyo.model;

import java.util.List;

public class Country {


    private String countryName;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<States> getStatesList() {
        return statesList;
    }

    public void setStatesList(List<States> statesList) {
        this.statesList = statesList;
    }

    private List<States> statesList;

    @Override
    public String toString() {
        return countryName;
    }
}
