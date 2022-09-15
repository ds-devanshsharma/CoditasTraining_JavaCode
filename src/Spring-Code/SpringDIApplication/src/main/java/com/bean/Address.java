package com.bean;

public class Address {
    private String City;
    private String locality;

    @Override
    public String toString() {
        return "[" +
                "City='" + City + '\'' +
                " locality='" + locality + '\'' +
                ']';
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }
}
