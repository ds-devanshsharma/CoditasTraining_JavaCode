package com.devansh.student.service;

import com.devansh.student.entities.Teacher;
import com.devansh.student.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository TeacherRepository;
    public ResponseEntity addTeacher(Teacher Teacher) {
        HashMap map = new HashMap();
        map.put("Error" , "Teacher Already Exist ! ");
        try {
            if (TeacherRepository.findById(Teacher.getTeacherId()).isPresent())
                return new ResponseEntity(map, HttpStatus.ALREADY_REPORTED);
            else
                return new ResponseEntity(TeacherRepository.save(Teacher), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity getTeachers() {
        try {
            List TeacherList = TeacherRepository.findAll();
            if (!TeacherList.isEmpty())
                return new ResponseEntity(TeacherList, HttpStatus.FOUND);
            else
                return new ResponseEntity("Error : Teacher Not Found", HttpStatus.NOT_FOUND);
        }
        catch (Exception e ){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deleteTeacher(int TeacherId) {
        try {
            Teacher Teacher = TeacherRepository.findById(TeacherId).orElse(null);
            if (Teacher != null) {
                TeacherRepository.delete(Teacher);
                return new ResponseEntity("Record Deleted Successfully !", HttpStatus.OK);
            } else
                return new ResponseEntity("Error : Record Not Found !", HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity updateTeacher(Teacher Teacher) {
        try{
            if(TeacherRepository.findById(Teacher.getTeacherId()).isPresent())
                return new ResponseEntity(TeacherRepository.save(Teacher),HttpStatus.ACCEPTED);
            else
                return new ResponseEntity("Teacher Not Found !",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}