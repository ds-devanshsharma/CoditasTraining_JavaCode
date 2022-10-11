package com.service;

import com.bean.Zoo;

import java.io.IOException;

public interface AnimalService {
    void addAnimalToZoo(Zoo zoo) throws IOException;
    void showAnimalInZoo(Zoo zoo);
    void deleteAnimalFromZoo(Zoo zoo) throws IOException;
    void updateAnimalInZoo(Zoo zoo);
}
