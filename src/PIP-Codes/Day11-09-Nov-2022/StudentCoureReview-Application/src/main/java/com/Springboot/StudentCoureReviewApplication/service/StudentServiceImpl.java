package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.entities.CourseEntity;
import com.Springboot.StudentCoureReviewApplication.entities.StudentEntity;
import com.Springboot.StudentCoureReviewApplication.repository.CourseRepository;
import com.Springboot.StudentCoureReviewApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    @Override
    public StudentEntity registerStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentEntity updateStudent(StudentEntity student) {
        StudentEntity updateStudent = studentRepository.findById(student.getStudentId()).orElse(null);
        if(updateStudent != null){
            updateStudent.setStudentCity(student.getStudentCity());
            updateStudent.setStudentName(student.getStudentName());
            updateStudent.setStudentEmail(student.getStudentEmail());
            updateStudent.setCourseList(student.getCourseList());
            updateStudent.setReviewList(student.getReviewList());
            return studentRepository.save(updateStudent);
        }
        return null;
    }

    @Override
    public boolean deleteStudent(Long studentId) {
        StudentEntity deleteStudent = studentRepository.findById(studentId).orElse(null);
        if(deleteStudent !=null){
            studentRepository.delete(deleteStudent);
            return true;
        }
        return false;
    }

    @Override
    public List<StudentEntity> showStudentList() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public boolean buyCourses(Long studentId,Long courseId) {
        CourseEntity buyCourse = courseRepository.findById(courseId).get();
        StudentEntity buyerStudent = studentRepository.findById(studentId).get();
        if(buyCourse != null && buyerStudent!= null) {
            buyerStudent.getCourseList().add(buyCourse);
            studentRepository.save(buyerStudent);
        }
        return false;
    }
}
