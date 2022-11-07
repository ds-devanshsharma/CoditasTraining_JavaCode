package com.devansh.student.service;

import com.devansh.student.entities.Student;
import com.devansh.student.entities.Teacher;
import com.devansh.student.repository.StudentRepository;
import com.devansh.student.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;

    public ResponseEntity addStudent(Student student) {
        HashMap map = new HashMap();
        map.put("Error" , "Student Already Exist ! ");
        try {
            if (studentRepository.findById(student.getStudentId()).isPresent())
                return new ResponseEntity(map, HttpStatus.ALREADY_REPORTED);
            else
                return new ResponseEntity(studentRepository.save(student), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity getStudents() {
        try {
            List studentList = studentRepository.findAll();
            if (!studentList.isEmpty())
                return new ResponseEntity(studentList, HttpStatus.FOUND);
            else
                return new ResponseEntity("Error : Student Not Found", HttpStatus.NOT_FOUND);
        }
        catch (Exception e ){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity deleteStudent(int studentId) {
        try {
            Student student = studentRepository.findById(studentId).orElse(null);
            if (student != null) {
                studentRepository.delete(student);
                return new ResponseEntity("Record Deleted Successfully !", HttpStatus.OK);
            } else
                return new ResponseEntity("Error : Record Not Found !", HttpStatus.NOT_FOUND);

        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity updateStudent(Student student) {
        try{
            if(studentRepository.findById(student.getStudentId()).isPresent())
                return new ResponseEntity(studentRepository.save(student),HttpStatus.ACCEPTED);
            else
                return new ResponseEntity("Student Not Found !",HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity assignTeacherToStudent(int studentId, int teacherId) {
        try{
            Student student = studentRepository.findById(studentId).orElse(null);
            Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
            if(student !=null && teacher!=null){
                student.getTeachers().add(teacher);
                studentRepository.save(student);
                teacher.getStudents().add(student);
                teacherRepository.save(teacher);
                return new ResponseEntity("Teacher assigned To student",HttpStatus.OK);
            }
            else
                return new ResponseEntity("Student or Teacher not found in Records !!",HttpStatus.NOT_FOUND);
        }catch(Exception e ){
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}