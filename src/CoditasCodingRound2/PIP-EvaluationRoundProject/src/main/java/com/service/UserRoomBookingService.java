package com.service;

import com.entities.Room;
import com.entities.User;

import java.util.Date;

public interface UserRoomBookingService {
    boolean addRoom(Room room);
    boolean addUser(User user);
    boolean addBooking(int userID, int roomID ,String date);
    boolean cancelBooking(int roomID);

}
