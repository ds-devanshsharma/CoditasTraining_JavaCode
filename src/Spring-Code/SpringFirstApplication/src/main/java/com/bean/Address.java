package com.bean;

public class Address {
    String Street;
    String locality;

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public String toString() {
        return "[Street='" + Street + ", locality='" + locality +"]";
    }
}
