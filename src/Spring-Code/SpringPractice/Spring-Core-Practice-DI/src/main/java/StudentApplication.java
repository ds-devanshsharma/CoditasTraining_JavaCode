package com.bean;

import com.bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApplication {
    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("SpringBean.xml");
            Student student = (Student) context.getBean("obj");
            System.out.println();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
