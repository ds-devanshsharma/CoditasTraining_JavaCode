package com.Springboot.StudentCoureReviewApplication.controller;

import com.Springboot.StudentCoureReviewApplication.entities.StudentEntity;
import com.Springboot.StudentCoureReviewApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/register")
    ResponseEntity registerStudentController(@RequestBody StudentEntity student){
        try {
            StudentEntity studentEntity = studentService.registerStudent(student);
            if (studentEntity != null)
                return new ResponseEntity(studentEntity, HttpStatus.CREATED);
            else return new ResponseEntity("Student not registered !", HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/showList")
    ResponseEntity showListController(){
        try {
            List<StudentEntity> studentList = studentService.showStudentList();
            if (studentList.size() > 0)
                return new ResponseEntity(studentList, HttpStatus.FOUND);
            else
                return new ResponseEntity("Students Not Found !", HttpStatus.NOT_FOUND);
        }catch (Exception e ){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteStudentController(@PathVariable Long id){
        try{
            if(studentService.deleteStudent(id))
                return new ResponseEntity("Student deleted !", HttpStatus.OK);
            else
                return new ResponseEntity("Student not Found ! ",HttpStatus.NOT_FOUND);
        }catch (Exception e ){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    ResponseEntity updateStudentController(@RequestBody StudentEntity student){
        try{
            StudentEntity updated = studentService.updateStudent(student);
            if(updated !=null)
                return new ResponseEntity(updated,HttpStatus.ACCEPTED);
            else
                return new ResponseEntity("updation not done !",HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e ){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/buyCourse/{studentId}/{CourseId}")
    ResponseEntity buyCourseController(@PathVariable Long studentId ,@PathVariable Long courseId){
        try{
            if(studentService.buyCourses(studentId,courseId))
                return new ResponseEntity("Course assigned !!" ,HttpStatus.OK);
            else
                return new ResponseEntity("Course OR Student not Found !",HttpStatus.NOT_FOUND);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
