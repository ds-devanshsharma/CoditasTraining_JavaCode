package com.DAOHotel;

import java.io.IOException;

public interface HotelOperation {
    void addHotel();
    void addDish() throws IOException;
    void displayDish();
    void deleteDish() throws IOException;
    void updateDish() throws IOException;
}
