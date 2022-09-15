package com.bean;

public class HelloPojo {
    private String name;
    Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name +", address=" + address +"]";
    }
}
