package com.bean;

public class Address {
    private int flat;
    private String city;
    private int pincode;

    public int getFlat() {
        return flat;
    }

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "flat=" + flat +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
