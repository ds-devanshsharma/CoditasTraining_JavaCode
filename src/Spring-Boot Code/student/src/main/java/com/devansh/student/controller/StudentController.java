package com.devansh.student.controller;

import com.devansh.student.entities.Student;
import com.devansh.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student) {
        try {
            Student student1 = studentService.addStudent(student);
            if (student1 != null)
                return new ResponseEntity(Optional.of(student1), HttpStatus.CREATED);
            else
                return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get")
    public ResponseEntity getStudents() {
        try {
            List<Student> students = studentService.getStudents();
            if (!students.isEmpty())
                return new ResponseEntity(Optional.of(students), HttpStatus.OK);
            else
                return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable int studentId) {
        try {
            boolean deleteStatus = studentService.deleteStudent(studentId);
            if (deleteStatus)
                return new ResponseEntity(HttpStatus.OK);
            else
                return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity updateStudent(@RequestBody Student student) {
        try {
            Student student1 = studentService.updateStudent(student);
            if (student1 != null)
                return new ResponseEntity(Optional.of(student1), HttpStatus.OK);
            else
                return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}