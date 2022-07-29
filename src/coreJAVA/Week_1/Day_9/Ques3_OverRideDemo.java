package coreJAVA.Week_1.Day_9;
class Parent{
    int area(int... a){
        return a[0]*a[1];
    }
}
class Child extends Parent{
//    float area(int... a){
//        return (float)Math.PI*a[0]*a[1];
//    }
    //we can change return type of overridden method due to its co-variant return type
}
public class Ques3_OverRideDemo {
}
