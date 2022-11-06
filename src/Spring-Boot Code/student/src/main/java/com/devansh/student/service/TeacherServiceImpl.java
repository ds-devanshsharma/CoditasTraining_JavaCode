package com.devansh.student.service;

import com.devansh.student.entities.Teacher;
import com.devansh.student.repository.StudentRepository;
import com.devansh.student.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    TeacherRepository teacherRepository;
    @Override
    public ResponseEntity addTeacher(Teacher teacher) {
        Teacher teacher1=teacherRepository.save(teacher);
        if(teacher1==null){
            return new ResponseEntity(Optional.of("TEACHER NOT CREATED ! "),HttpStatus.NOT_ACCEPTABLE);
        }
        else{
            HashMap hashMap=new HashMap();
            hashMap.put("data",teacher1);
            hashMap.put("message","Teacher inserted");
         return new ResponseEntity(Optional.of(hashMap),HttpStatus.CREATED);
        }
    }


}