package com.main;

import com.DAO.JDBC.CrudJDBCImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        CrudJDBCImplementation implementation = (CrudJDBCImplementation) context.getBean("Implementation");
        new Menu().menu();
    }
}
