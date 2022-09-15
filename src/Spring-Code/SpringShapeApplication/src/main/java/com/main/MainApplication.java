package com.main;

import com.bean.Circle;
import com.bean.Rectangle;
import com.bean.Triangle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
//        com.bean.Circle circle=(Circle) context.getBean("circle");
//        com.bean.Triangle triangle = (Triangle)context.getBean("triangle");
//        System.out.println(circle);
//        System.out.println(triangle);

        //Passing Multiple Configuration files in ClassPathXmlApplicationContext("config1","config2.xml")

        ApplicationContext context = new ClassPathXmlApplicationContext("config2.xml","config.xml");
        com.bean.Circle circle = (Circle)context.getBean("circle");
        com.bean.Rectangle rectangle = (Rectangle)context.getBean("rectangle");
        com.bean.Triangle triangle = (Triangle)context.getBean("triangle");
        // for circle and triangle we have give implementation of Area() in toString()
        System.out.println(circle);
        System.out.println(triangle);
        System.out.println("Rectangle Area : "+rectangle.area());
    }
}
