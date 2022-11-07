package com.service;

import com.entities.Booking;
import com.entities.Room;
import com.entities.User;
import com.hibernateUtil.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.*;
import java.util.stream.Collectors;

public class UserRoomBookingServiceImpl implements UserRoomBookingService{
    SessionFactory sessionFactory ;
    Booking booking;
    User user;
    Room room;
    public UserRoomBookingServiceImpl(){
        sessionFactory = SessionFactoryProvider.getSessionFactoryMethod();
    }
    @Override
    public int addRoom(Room room) {
        int status =0;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Room where roomName =:roomName ");
            query.setParameter("roomName", room.getRoomName());
            if(query.list().size() > 0 ) return -1 ;
            session.save(room);
            session.getTransaction().commit();
            session.close();
            return 1;
        }catch (Exception e ) {
            session.getTransaction().rollback();
            session.close();
            return 0;
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
    public int  addBooking(int userId,int roomId,Booking booking ) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            //this is to check room Slot available or not
            /*
            SELECT * FROM user_room_database.booking where startDate >= "2022-11-02" and endDate <= "2022-11-02"
            and startTime <="15:57" and endTime >= "15:57";
             */
            Query query = session.createQuery("from Booking where startDateTime >= :bookingStartDateTime and startDateTime <= : bookingEndDateTime " +
                    " OR endDateTime >=: bookingStartDateTime and endDateTime <= :bookingEndDateTime and roomID =:room ");
            query.setParameter("bookingStartDateTime" , booking.getStartDateTime());
            query.setParameter("bookingEndDateTime" , booking.getEndDateTime());
            query.setParameter("room",roomId);
            if(query.list().size() > 0 ) return 11;

            user = session.get(User.class,userId);
            room = session.get(Room.class,roomId);
            System.out.println(user);
            System.out.println(room);
            if(user==null || room == null)return 0;
            else{
                booking.setUserID(userId);
                booking.setRoomID(roomId);
            }
            user.setRoom(room);
            session.save(booking);
            session.getTransaction().commit();
            session.close();
            return 1;
        }catch (Exception e ) {
            session.getTransaction().rollback();
            session.close();
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean cancelBooking(int bookingID ,int userID) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        // getting room based on roomId
        try{
            booking = session.get(Booking.class,bookingID);
            user = session.get(User.class,userID);

            user.setRoom(null);
            session.delete(booking);
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e ){
            session.getTransaction().rollback();
            session.close();
            return false;
        }
    }

    @Override
    public List<Booking> bookingDetail(String beginDate, String lastDate) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try{
            Query query = session.createQuery("from Booking where startDateTime >=:begin and startDateTime <=:end");
            query.setParameter("begin",beginDate);
            query.setParameter("end",lastDate);
            return query.list();
        }catch (Exception e){
         return null;
        }
    }
    @Override
    public List<Room> checkRoomAvailability(String checkDateTime) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        List<Room> allRoomList = session.createQuery("from Room ").list();
//        Query query = session.createQuery(" from Booking where startDateTime <=: check " +
//                "and endDateTime >= :check");
//        query.setParameter("check",checkDateTime);
//        List<Booking> bookingList =query.list();
//        List<Integer> bookedRoomIdList = bookingList.stream().map(booking1 -> booking1.getRoomID()).collect(Collectors.toList());
//
//        List<Room> availableRoomList = new ArrayList<>();
//        for(Room room : allRoomList){
//            if(!bookedRoomIdList.contains(room.getRoomID())) availableRoomList.add(room);
//        }
       Query query = session.createQuery("from Room Left outer Join Booking" +
                "on Room.roomID = Booking.roomID Minus (from Room inner Join Booking on Room.roomID = Booking.roomID " +
                "where startDateTime <=: check and endDateTime >= :check)");
       query.setParameter("check",checkDateTime);
       List<Room> availableRoomList = query.list();
       System.out.println(availableRoomList);
       return availableRoomList;
    }

    @Override
    public int checkRoomAvailabilityById(int roomId, String dateTime) {
        Session session = sessionFactory.openSession();
//        session.beginTransaction();
        Query query = session.createQuery("from Booking where startDateTime <=:check  and endDateTime >=:check ");
        query.setParameter("check",dateTime);

        if(query.list().size()>0)return 1;
        else return 0;
    }
}
