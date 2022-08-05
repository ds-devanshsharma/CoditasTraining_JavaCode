package coreJAVA.Week_1.Day_11;
// static import allows us to use static members of class directly without using className or any obj
//but this leads to lots of confusion thats developers point about staic import
import java.lang.Math.*;

import static java.lang.Math.sqrt;
import static java.lang.System.out;

public class StaticImportDemo {
    public static void main(String[] args) {
        System.out.println("Square Root using Math.sqrt() :"+ Math.sqrt(25));
        // using Math's class's staic sqrt() method without using ClassName Math along with it
        System.out.println("Square Root using Direct sqrt() :"+sqrt(25));

        //using System's class static variable out directly
        out.println("This message is printed without using System Keyword !!");

    }
}
/*
Square Root using Math.sqrt() :5.0
Square Root using Direct sqrt() :5.0
This message is printed without using System Keyword !!

 */