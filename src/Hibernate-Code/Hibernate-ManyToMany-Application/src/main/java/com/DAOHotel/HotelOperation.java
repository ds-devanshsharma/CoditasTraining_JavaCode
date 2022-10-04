package com.DAOHotel;

import java.io.IOException;

public interface HotelOperation {
    void addDish() throws IOException;
    void displayDish();
    void deleteDish() throws IOException;
    void updateDish() throws IOException;
}
