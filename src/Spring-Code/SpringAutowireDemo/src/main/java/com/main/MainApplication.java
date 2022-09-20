package com.main;

import com.bean.Address;
import com.bean.Employee;
import com.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ByName.xml");
        Scanner scanner= new Scanner(System.in);
        //getBean("ref")
        //getBean("classname")
        //getBean("ref","classname")
        System.out.println(context.getBean("student"));
// getBean("object" , "all the values respective to constructor")
//        System.out.println(context.getBean("student",11078,"Devansh"
//                ,new Address("Kanpur","UP")));

        System.out.println("****************************");
        com.bean.Employee employee = (com.bean.Employee)context.getBean("employee");
        System.out.println(employee);
    }
}
