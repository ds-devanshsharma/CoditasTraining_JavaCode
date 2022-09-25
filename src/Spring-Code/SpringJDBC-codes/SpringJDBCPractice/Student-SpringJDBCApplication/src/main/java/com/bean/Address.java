package com.bean;

public class Address {
    private int flatNo;
    private String city;
    private int pincode;

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "flatNo=" + flatNo +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                '}';
    }

    public int getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(int flatNo) {
        this.flatNo = flatNo;
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
}
