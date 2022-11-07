package com.jpa.hibernate.SpringBootHibernateJPA.repository;

import com.jpa.hibernate.SpringBootHibernateJPA.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}