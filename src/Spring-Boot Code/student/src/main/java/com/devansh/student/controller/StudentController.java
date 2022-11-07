package com.devansh.student.controller;

import com.devansh.student.entities.Student;
import com.devansh.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/addStudent")
    ResponseEntity addStudentController(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/getStudentList")
    ResponseEntity getStudentListController(){
        return studentService.getStudents();
    }
    @DeleteMapping("deleteStudent/{studentId}")
    ResponseEntity deleteStudentController(@PathVariable int studentId){
        return studentService.deleteStudent(studentId);
    }

    @PatchMapping("/updateStudent")
    ResponseEntity updateStudentController(@RequestBody Student student){
        return studentService.updateStudent(student);
    }
    @GetMapping("/assignTeacherToStudent/{studentId}/{teacherId}")
    ResponseEntity assignTeacherToStudent(@PathVariable int studentId , @PathVariable int teacherId){
        return studentService.assignTeacherToStudent(studentId,teacherId);
    }
}