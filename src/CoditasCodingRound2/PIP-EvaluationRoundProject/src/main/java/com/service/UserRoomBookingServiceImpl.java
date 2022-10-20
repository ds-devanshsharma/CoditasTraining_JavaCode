package com.service;

import com.entities.Booking;
import com.entities.Room;
import com.entities.User;
import com.hibernateUtil.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

public class UserRoomBookingServiceImpl implements UserRoomBookingService{
    SessionFactory sessionFactory ;
    Booking booking;
    User user;
    Room room;
    public UserRoomBookingServiceImpl(){
        sessionFactory = SessionFactoryProvider.getSessionFactoryMethod();
    }
    @Override
    public boolean addRoom(Room room) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(room);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e ) {
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean addUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            session.save(user);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e ) {
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean addBooking(int userID, int roomID, String date) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            user = session.get(User.class,userID);
            room = session.get(Room.class,roomID);
            booking = new Booking();
            booking.setDateTime(date);
            booking.setRoom(room);
            booking.setUser(user);
            session.save(booking);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e ) {
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    @Override
    public boolean cancelBooking(int roomID) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // getting room based on roomId
        try{
            room = session.get(Room.class,roomID);
            session.delete(room);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e ){
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }
}
