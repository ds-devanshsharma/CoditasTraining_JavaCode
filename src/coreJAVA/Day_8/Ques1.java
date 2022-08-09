package coreJAVA.Day_8;

/**
 * 1)Write a program in which you will declare an abstract class Vehicle inherits this
 * class from two classes car and truck using the method engine in both display "car has
 * good engine" and "truck has bad engine".
 */
abstract class Vehicle{
    abstract void engine();
}
class Car extends Vehicle{
    @Override
    void engine(){
        System.out.println("Car has good Engine !!");
    }
}
class Truck extends Vehicle{
    @Override
     void engine(){
        System.out.println("Truck has Bad Engine !!");
    }
}
public class Ques1 {
    public static void main(String[] args) {
        Vehicle vehicle;
        vehicle = new Car();
        vehicle.engine();

        vehicle= new Truck();
        vehicle.engine();
        /*
        Car has good Engine !!
        Truck has Bad Engine !!
         */
    }
}
