package com.main;

import com.entities.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JPAapplication {
    public static void main(String[] args) throws IOException {
        Student student =null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EntityManagerFactory entityManagerFactory = Persistence.
                createEntityManagerFactory("devansh");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        boolean flag = true;
        while(flag) {
            student = new Student();
//            System.out.println("Enter student ID : ");
//            student.setStudentID(Integer.parseInt(reader.readLine()));
            System.out.println("Enter student Name : ");
            student.setName(reader.readLine());
            System.out.println("Enter student Dept : ");
            student.setDept(reader.readLine());
            System.out.println(entityManager+"==="+student);
            entityManager.persist(student);
            System.out.println("ADD MORE PRESS -1 \n" +
                    "DONT WANT TO ADD -0 ");flag=false;
        }
        entityManager.getTransaction().commit();
    }
}
