package com.service;

import com.bean.Animal;
import com.bean.Zoo;

import java.io.IOException;

public interface ZooService {
    void addZoo(Zoo zoo);

    void displayZoo(int zooID);
    void displayZooList();
    void deleteZoo(int zooID);
    void updateZoo(int zooID) throws IOException;
}
