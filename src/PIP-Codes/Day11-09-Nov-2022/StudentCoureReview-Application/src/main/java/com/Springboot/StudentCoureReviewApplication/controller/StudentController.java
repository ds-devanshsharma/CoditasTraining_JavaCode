package com.Springboot.StudentCoureReviewApplication.controller;

import com.Springboot.StudentCoureReviewApplication.dto.request.UpdateStudentDto;
import com.Springboot.StudentCoureReviewApplication.entities.StudentEntity;
import com.Springboot.StudentCoureReviewApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/register")
    ResponseEntity registerStudentController(@RequestBody StudentEntity student){
        HashMap map = new HashMap();
        try {

            StudentEntity studentEntity = studentService.registerStudent(student);
            if (studentEntity != null) {
                map.put("Student Registered ! ", studentEntity);
                return new ResponseEntity(map, HttpStatus.CREATED);
            }else
                return new ResponseEntity("Student not registered !", HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            return new ResponseEntity("Some Error Occurred !",HttpStatus.INTERNAL_SERVER_ERROR);
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
    ResponseEntity updateStudentController(@RequestBody UpdateStudentDto updateStudent){
        try{
            StudentEntity updated = studentService.updateStudent(updateStudent);
            if(updated !=null)
                return new ResponseEntity(updated,HttpStatus.ACCEPTED);
            else
                return new ResponseEntity("updation not done !",HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e ){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/buyCourse/{studentId}/{courseId}")
    ResponseEntity buyCourseController(@PathVariable Long studentId ,@PathVariable Long courseId){
        try{
            int status = studentService.buyCourses(studentId,courseId);
            if(status == 0 )
                return new ResponseEntity("Course not Found !",HttpStatus.NOT_FOUND);
            else if(status == 11)
                return new ResponseEntity("YOU HAVE ALREADY TAKEN THIS COURSE !",HttpStatus.NOT_ACCEPTABLE);
            else if(status == 2)
                return new ResponseEntity("STUDENT NOT FOUND !",HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity("COURSE ASSIGNED !",HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
