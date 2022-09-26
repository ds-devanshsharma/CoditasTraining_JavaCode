package com.main;

import com.DAO.JDBC.CrudJDBCImplementation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;

public class MainApplication {
    static CrudJDBCImplementation implementation;
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring.xml");
        implementation = context.getBean("jdbcImplementation",CrudJDBCImplementation.class);
        new Menu().menu();
    }
}
