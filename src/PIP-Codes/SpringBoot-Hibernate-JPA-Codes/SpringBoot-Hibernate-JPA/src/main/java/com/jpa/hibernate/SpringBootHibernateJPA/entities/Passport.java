package com.jpa.hibernate.SpringBootHibernateJPA.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passport {
    @Id
    @GeneratedValue
    private int passportId;
    @Column(nullable = false)
    private String  passportNumber;

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportId=" + passportId +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
