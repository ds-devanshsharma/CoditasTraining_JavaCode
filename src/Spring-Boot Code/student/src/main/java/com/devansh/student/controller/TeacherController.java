package com.devansh.student.controller;

import com.devansh.student.entities.Teacher;
import com.devansh.student.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Teacher")
public class TeacherController {
    @Autowired
    TeacherService TeacherService;
    @PostMapping("/addTeacher")
    ResponseEntity addTeacherController(@RequestBody Teacher Teacher){
        return TeacherService.addTeacher(Teacher);
    }

    @GetMapping("/getTeacherList")
    ResponseEntity getTeacherListController(){
        return TeacherService.getTeachers();
    }
    @DeleteMapping("deleteTeacher/{TeacherId}")
    ResponseEntity deleteTeacherController(@PathVariable int TeacherId){
        return TeacherService.deleteTeacher(TeacherId);
    }

    @PatchMapping("/updateTeacher")
    ResponseEntity updateTeacherController(@RequestBody Teacher Teacher){
        return TeacherService.updateTeacher(Teacher);
    }
}