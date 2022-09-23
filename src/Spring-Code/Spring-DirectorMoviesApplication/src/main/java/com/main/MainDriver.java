package com.main;

import com.bean.Director;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDriver {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
        Director director = (Director)context.getBean("director1");
        System.out.println(director);
        System.out.println(director.getProperties());
    }
}
