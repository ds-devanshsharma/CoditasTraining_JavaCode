package com.Main;

import com.service.Service;
import com.service.ServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Service service = new ServiceImpl();

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session  =sessionFactory.openSession();
        session.beginTransaction();

        while(true) {
            System.out.println("Enter 1 to register Teacher ! \n" +
                    "Enter 2 to addCourses for Teacher ! \n" +
                    "Enter 3 to display teacher&TheirCourses !\n" +
                    "Enter 4 to delete Teacher ! " +
                    "Enter 0  to exit ! \n" +
                    "");
            switch (Integer.parseInt(reader.readLine())) {
                case 1 :
                    service.registerTeacher();
                    break;
                case 2:
                    service.addTeacherCourses();
                    break;
                case 3 :
                    service.showTeacherAndTheirCourses();
                    break;
                case 4 :
                    service.deleteTeacher();
                    break;
                case 0 :
                    System.exit(9);
            }
        }
    }
}
