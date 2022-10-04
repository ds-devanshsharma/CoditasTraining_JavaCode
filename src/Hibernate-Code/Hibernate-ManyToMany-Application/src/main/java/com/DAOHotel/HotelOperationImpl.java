package com.DAOHotel;

import com.bean.Dish;
import com.bean.Hotel;
import com.utils.SessionFactoryMaker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;

public class HotelOperationImpl implements HotelOperation{
    SessionFactory sessionFactory = SessionFactoryMaker.sessionFactoryProvider();
    Hotel hotel;
    Dish dish;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    boolean flag= true;
    @Override
    public void addDish() throws IOException {
        hotel = new Hotel();
        System.out.println("ENTER HOTEL ID :");hotel.setHotelID(Integer.parseInt(reader.readLine()));
        System.out.println("ENTER HOTEL NAME : ");hotel.setHotelName(reader.readLine());
        System.out.println("ENTER HOTEL RATING : ");hotel.setHotelRating(Float.parseFloat(reader.readLine()));

        // adding Hotel Dishes
        HashSet<Dish> dishSet  = new HashSet<>();

        System.out.println("Enter DishSet : ");
        while(flag){
            dish = new Dish();
            System.out.println("ENTER 1- ADD DISH \n" +
                    "ENTER 0- GOBACK \n");
            try {
                switch (Integer.parseInt(reader.readLine())) {
                    case 1:
                        System.out.println("ENTER DISH ID : ");
                        dish.setDishID(Integer.parseInt(reader.readLine()));
                        System.out.println("ENTER DISH NAME : ");
                        dish.setDishName(reader.readLine());
                        System.out.println("ENETR DISH PRICE :");
                        dish.setDishPrice(Float.parseFloat(reader.readLine()));
                        dishSet.add(dish);
                    case 0:
                        flag = false;
                }
            }catch (Exception e ){
                System.out.println(e.getMessage());
                addDish();
            }
        }
        hotel.setDishes(dishSet);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(hotel.getDishes());
        session.save(hotel);
        session.getTransaction().commit();
        System.out.println("RECORD ADDED SUCCESSFULLY !! ");
    }

    @Override
    public void displayDish() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Hotel> list = session.createQuery("from Hotel").list();
        for(Hotel hotel1 : list)
            System.out.println(hotel1);

    }

    @Override
    public void deleteDish() throws IOException {
        System.out.println("Enter Hotel ID : ");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        hotel = (Hotel) session.get(Hotel.class,Integer.parseInt(reader.readLine()));
        session.delete(hotel.getDishes());
        session.delete(hotel);
        session.getTransaction().commit();
        System.out.println("RECORD DELETED SUCCESSFULLY !! ");
    }

    @Override
    public void updateDish() throws IOException {
        System.out.println("ENTER HOTEL ID TO DELETE : ");
        Session session = sessionFactory.openSession();
        hotel = (Hotel) session.get(Hotel.class,Integer.parseInt(reader.readLine()));
        while(flag){
            System.out.println("ENTER 1-Update ");
        }

    }
}
