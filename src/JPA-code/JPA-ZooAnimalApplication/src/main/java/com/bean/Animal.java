package com.bean;

import javax.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalID;
    private String animalName;
    private String category;
    @ManyToOne(cascade = CascadeType.ALL)
    private Zoo zoo;
    @Override
    public String toString() {
        return "Animal{" +
                "animalID=" + animalID +
                ", animalName='" + animalName + '\'' +
                ", category='" + category + '\'' +

                '}';
    }

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
