package com.bean;

public class Circle {
    int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Area of Circle : "+Math.PI * radius* radius;
    }
}
