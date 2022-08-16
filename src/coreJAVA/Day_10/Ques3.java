package coreJAVA.Day_10;

import java.lang.reflect.Field;

/**
 * Try to get information about Private variable of a class using Reflection
 */
class PrivateReflection{
    private int id = 10;
}
public class Ques3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        PrivateReflection privateReflection = new PrivateReflection();
        Class c = Class.forName("coreJAVA.Day_10.PrivateReflection");
       Field field = c.getDeclaredField("id");
       field.setAccessible(true);
       System.out.println("Value of "+c.getDeclaredField("id")+" private value before changes: "+field.get(privateReflection));
        field.set(privateReflection,15);
        System.out.println("Value of "+c.getDeclaredField("id")+" private value After changes: "+field.get(privateReflection));
    }
}
/*
Value of private int coreJAVA.Day_10.PrivateReflection.id private value before changes: 10
Value of private int coreJAVA.Day_10.PrivateReflection.id private value After changes: 15 */
