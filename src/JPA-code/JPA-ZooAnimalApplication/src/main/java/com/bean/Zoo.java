package com.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zooID;
    private String zooName;
    @OneToMany( cascade = CascadeType.ALL , mappedBy = "zoo")
    private List<Animal> animal;

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    public int getZooID() {
        return zooID;
    }

    public void setZooID(int zooID) {
        this.zooID = zooID;
    }

    public String getZooName() {
        return zooName;
    }

    public void setZooName(String zooName) {
        this.zooName = zooName;
    }



    @Override
    public String toString() {
        return "Zoo{" +
                "zooID=" + zooID +
                ", zooName='" + zooName + '\'' +
                ", animal=" + animal +
                '}';
    }
}
