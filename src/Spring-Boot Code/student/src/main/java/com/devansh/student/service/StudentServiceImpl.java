package com.devansh.student.service;

import com.devansh.student.entities.Student;
import com.devansh.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public boolean deleteStudent(int studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            studentRepository.delete(student);
            return true;
        }
        else
            return false;
    }

    @Override
    public Student updateStudent(Student student) {
        Student existingStudent = studentRepository.findById(student.getStudentId()).orElse(null);
        if (existingStudent != null) {
            existingStudent.setStudentName(student.getStudentName());
            return studentRepository.save(existingStudent);
        }
        else
            return null;
    }
}