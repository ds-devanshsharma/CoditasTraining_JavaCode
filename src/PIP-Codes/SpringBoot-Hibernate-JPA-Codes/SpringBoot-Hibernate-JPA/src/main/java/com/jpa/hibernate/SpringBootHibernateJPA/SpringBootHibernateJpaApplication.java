package com.jpa.hibernate.SpringBootHibernateJPA;

import com.jpa.hibernate.SpringBootHibernateJPA.repository.CourseRepository;
import com.jpa.hibernate.SpringBootHibernateJPA.repository.StudentRepository;
import com.jpa.hibernate.SpringBootHibernateJPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHibernateJpaApplication implements CommandLineRunner{
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	StudentService studentService;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		studentService.retrieveStudentAndCourses(101);
//		studentService.insertStudentAndCourse();
//		studentService.addCourseToStudent(101);
		studentService.addStudentToCourse(6);
	}
}
