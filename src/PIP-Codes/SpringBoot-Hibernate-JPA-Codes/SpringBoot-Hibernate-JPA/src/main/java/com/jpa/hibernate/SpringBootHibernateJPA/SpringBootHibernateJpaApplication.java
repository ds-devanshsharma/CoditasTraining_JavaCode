package com.jpa.hibernate.SpringBootHibernateJPA;

import com.jpa.hibernate.SpringBootHibernateJPA.JpaReposistory.CourseRepository;
import com.jpa.hibernate.SpringBootHibernateJPA.entities.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHibernateJpaApplication {
	@Autowired
	private CourseRepository courseRepository;
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateJpaApplication.class, args);

	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		Course course = courseRepository.findById(1001L);
//		logger.info("Course -> {} ",course);
//	}
}
