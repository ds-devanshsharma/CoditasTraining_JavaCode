package com.service;

import com.entities.Booking;
import com.entities.Room;
import com.entities.User;

import java.util.Date;
import java.util.List;

public interface UserRoomBookingService {
    int addRoom(Room room);
    boolean addUser(User user);
    int addBooking(int userId, int roomId ,Booking booking);
    boolean cancelBooking(int roomID ,int userId);
    List<Booking> bookingDetail(String startDate , String lastDate );
    List<Room> checkRoomAvailability(String checkDateTime);

    int checkRoomAvailabilityById(int roomId, String dateTime);
}
