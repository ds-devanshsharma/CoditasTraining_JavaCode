package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
        System.out.println((com.bean.Student)context.getBean("student"));
    }
}
// output<!--        [Studentid=11056 name='Devansh', address=[City='Kanpur' locality='Kalyanpur']]-->