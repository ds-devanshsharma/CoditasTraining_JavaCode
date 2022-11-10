package com.Springboot.StudentCoureReviewApplication.controller;

import com.Springboot.StudentCoureReviewApplication.entities.CourseEntity;
import com.Springboot.StudentCoureReviewApplication.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Course")
public class CourseController {
    @Autowired
    CourseService CourseService;
    @PostMapping("/register")
    ResponseEntity registerCourseController(@RequestBody CourseEntity Course){
        try {
            CourseEntity CourseEntity = CourseService.registerCourse(Course);
            if (CourseEntity != null)
                return new ResponseEntity(CourseEntity, HttpStatus.CREATED);
            else return new ResponseEntity("Course not registered !", HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/showList")
    ResponseEntity showListController(){
        try {
            List<CourseEntity> CourseList = CourseService.showCourseList();
            if (CourseList.size() > 0)
                return new ResponseEntity(CourseList, HttpStatus.FOUND);
            else
                return new ResponseEntity("Courses Not Found !", HttpStatus.NOT_FOUND);
        }catch (Exception e ){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    ResponseEntity deleteCourseController(@PathVariable Long id){
        try{
            if(CourseService.deleteCourse(id))
                return new ResponseEntity("Course deleted !", HttpStatus.OK);
            else 
                return new ResponseEntity("Course not Found ! ",HttpStatus.NOT_FOUND);
        }catch (Exception e ){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/update")
    ResponseEntity updateCourseController(@RequestBody CourseEntity Course){
        try{
            CourseEntity updated = CourseService.updateCourse(Course);
            if(updated !=null)
                return new ResponseEntity(updated,HttpStatus.ACCEPTED);
            else 
                return new ResponseEntity("updation not done !",HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e ){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
