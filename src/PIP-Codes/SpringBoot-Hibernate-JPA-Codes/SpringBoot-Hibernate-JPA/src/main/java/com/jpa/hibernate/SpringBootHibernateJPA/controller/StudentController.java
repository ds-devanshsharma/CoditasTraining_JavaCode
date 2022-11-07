//package com.jpa.hibernate.SpringBootHibernateJPA.controller;
//
//import com.jpa.hibernate.SpringBootHibernateJPA.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/student")
//public class StudentController {
//    @Autowired
//    StudentService studentService;
//
//    @GetMapping("/getDetails/{studentId}")
//    ResponseEntity getStudentAndCourseDetails(@PathVariable int studentId){
//        return studentService.retrieveStudentAndCourses(studentId);
//    }
//}
