package com.main;

import com.JpaUtils.JpaEntityManagerFactoryProvider;
import com.entities.Student;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.Comparator;
import java.util.stream.Collectors;

public class JpaMainApplication {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = JpaEntityManagerFactoryProvider
                .entityManagerFactoryProvider();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // building query for  : SELECT * FROM STUDENT
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> studentCriteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> studentRoot =  studentCriteriaQuery.from(Student.class);
        studentCriteriaQuery.select(studentRoot);

        //Typed Query now
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery(studentCriteriaQuery);
        studentTypedQuery.getResultStream().forEach(System.out::println);
        System.out.println("*************************************************");
//        studentTypedQuery.getResultList()
//                .stream()
//                .sorted(Comparator.comparingInt(item-> (int) item.getStudentRating()))
//                .forEach(System.out::println);



//        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("from Student where studentRating > :rating ");
//        query.setParameter("rating",6.0f);
//        query.executeUpdate(); not working !!!

        criteriaBuilder = entityManager.getCriteriaBuilder();
        studentCriteriaQuery = criteriaBuilder.createQuery(Student.class);
        studentRoot =  studentCriteriaQuery.from(Student.class);
        ParameterExpression<Float> studentParameter = criteriaBuilder.parameter(Float.class);
        studentCriteriaQuery.select(studentRoot).where(criteriaBuilder.gt(studentRoot.get("studentRating"),studentParameter));
    // now typed query for parameterised query like
        /*
        SELECT * FROM STUDENT WHERE STUDENT-RATING > 8.0
         */
        TypedQuery<Student> typedQuery = entityManager.createQuery(studentCriteriaQuery);
        typedQuery.setParameter(studentParameter,8.0f);
        typedQuery.getResultList().stream()
                .forEach(System.out::println);
    //  finding out max rating result
        criteriaBuilder = entityManager.getCriteriaBuilder();
        studentCriteriaQuery = criteriaBuilder.createQuery(Student.class);
        studentRoot =  studentCriteriaQuery.from(Student.class);
        typedQuery = entityManager.createQuery(studentCriteriaQuery);

    }
}
