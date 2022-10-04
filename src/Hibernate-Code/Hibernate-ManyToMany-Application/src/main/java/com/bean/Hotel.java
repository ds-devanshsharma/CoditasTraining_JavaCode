package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Hotel {
    @Id
    private int hotelID;
    private String hotelName;
    private float hotelRating;
    @OneToMany
    private Set<Dish> dishes;

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelID=" + hotelID +
                ", hotelName='" + hotelName + '\'' +
                ", hotelRating=" + hotelRating +
                ", dishes=" + dishes +
                '}';
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public float getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(float hotelRating) {
        this.hotelRating = hotelRating;
    }

}
