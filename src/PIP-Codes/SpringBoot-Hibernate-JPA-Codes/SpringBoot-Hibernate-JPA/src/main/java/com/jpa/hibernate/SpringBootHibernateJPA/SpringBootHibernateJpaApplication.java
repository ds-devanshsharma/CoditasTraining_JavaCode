package com.jpa.hibernate.SpringBootHibernateJPA;

import com.jpa.hibernate.SpringBootHibernateJPA.repository.CourseRepository;
import com.jpa.hibernate.SpringBootHibernateJPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHibernateJpaApplication {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateJpaApplication.class, args);
	}
}
