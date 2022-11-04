package com.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingID;
    private int userID ;

    @Override
    public String toString() {
        return
                "[ bookingID=" + bookingID +
                ", userID=" + userID +
                ", roomID=" + roomID +
                ", startDateTime='" + startDateTime + '\'' +
                ", endDateTime='" + endDateTime + " ]";
    }

    private int roomID ;
    private String startDateTime;
    private String endDateTime;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }
}
