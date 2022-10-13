package com.bean;

import javax.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalID;
    private String animalName;
    private int animalAge;
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private Zoo zoo;

    @Override
    public String toString() {
        return "Animal{" +
                "animalID=" + animalID +
                ", animalName='" + animalName + '\'' +
                ", animalAge=" + animalAge +
                ", category='" + category + '\'' +
                '}';
    }

    public int getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(int animalAge) {
        this.animalAge = animalAge;
    }

    private String category;

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }


}
