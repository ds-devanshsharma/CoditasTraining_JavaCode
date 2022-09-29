package com.bean;

import javax.persistence.*;

@Entity
public class Address {
    @Id@Column(name = "FLAT_NO")
    private int flatNo;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @Column(name = "PINCODE")
    private String pinCode;

    @ManyToOne
    private SavingAccount savingAccount;
    @ManyToOne
    private CurrentAccount currentAccount;

    @Override
    public String toString() {
        return "Address{" +
                "flatNo=" + flatNo +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", savingAccount=" + savingAccount +
                ", currentAccount=" + currentAccount +
                '}';
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

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public CurrentAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(CurrentAccount currentAccount) {
        this.currentAccount = currentAccount;
    }
}
