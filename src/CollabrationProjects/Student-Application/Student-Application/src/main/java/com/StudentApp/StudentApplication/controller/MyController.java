package com.StudentApp.StudentApplication.controller;

import com.StudentApp.StudentApplication.entities.Student;
import com.StudentApp.StudentApplication.services.StudentDAO;
import com.StudentApp.StudentApplication.services.StudentDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    StudentDAO studentDAO;
    @PostMapping("/registerStudent")
    void registerStudentController(@RequestBody Student student){
        studentDAO.registerStudent(student);
    }
    @PostMapping("/updateStudent")
    void updateStudentController(@RequestBody Student student){
        studentDAO.updateStudent(student);
    }

    @GetMapping("/fetchAllStudent")
    List<Student> fetchAllStudentController(){
        return studentDAO.fetchAllStudent();
    }

//    @GetMapping("/fetchStudentById/{enrollmentID}")
//    Student fetchStudentByIdController(@PathVariable int id){
//        return studentDAO.fetchStudentById(id);
//    }

    @DeleteMapping("/deleteStudent/{enrollmentNumber}")
    void deleteStudentController(@PathVariable int enrollmentNumber){
        studentDAO.deleteStudent(enrollmentNumber);
    }
}
