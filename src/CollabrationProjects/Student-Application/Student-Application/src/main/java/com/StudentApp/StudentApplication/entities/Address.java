package com.StudentApp.StudentApplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private int flatNo;
    private String street;
    private String city;
    private int pinCode;

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", flatNo=" + flatNo +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(int flatNo) {
        this.flatNo = flatNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
