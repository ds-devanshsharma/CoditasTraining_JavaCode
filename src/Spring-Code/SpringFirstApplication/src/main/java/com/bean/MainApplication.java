package com.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
        HelloPojo helloPojo=(HelloPojo) context.getBean("helloPojo");
        System.out.println(helloPojo);
    }
}
