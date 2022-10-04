package com.StudentApp.StudentApplication.controller;

import com.StudentApp.StudentApplication.entities.Student;
import com.StudentApp.StudentApplication.services.StudentDAO;
import com.StudentApp.StudentApplication.services.StudentDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
public class MyController {
    @Autowired
    StudentDAO studentDAO;
    @PostMapping("/registerStudent")
    void registerStudentController(@RequestBody Student student){
        studentDAO.registerStudent(student);
    }
    @PutMapping("/updateStudent")
    void updateStudentController(@RequestBody Student student){
        studentDAO.updateStudent(student);
    }

    @GetMapping("/fetchAllStudent")
    ResponseEntity fetchAllStudentController(){
        List<Student> students=studentDAO.fetchAllStudent();
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("data","Data Not Found");
        if(students.size()>0)
            return new ResponseEntity(Optional.of(students), HttpStatus.FOUND);
        return new ResponseEntity(Optional.of(hashMap),HttpStatus.NOT_FOUND);
    }

    @GetMapping("/fetchStudentById/{enrollmentID}")
    Student fetchStudentByIdController(@PathVariable int enrollmentID){
        return studentDAO.fetchStudentById(enrollmentID);
    }

    @DeleteMapping("/deleteStudent/{enrollmentNumber}")
    void deleteStudentController(@PathVariable int enrollmentNumber){
        studentDAO.deleteStudent(enrollmentNumber);
    }
}
