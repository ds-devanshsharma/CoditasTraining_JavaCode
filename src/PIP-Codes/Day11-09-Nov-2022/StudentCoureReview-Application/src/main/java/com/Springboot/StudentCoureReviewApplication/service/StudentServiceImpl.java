package com.Springboot.StudentCoureReviewApplication.service;

import com.Springboot.StudentCoureReviewApplication.dto.request.UpdateStudentDto;
import com.Springboot.StudentCoureReviewApplication.entities.CourseEntity;
import com.Springboot.StudentCoureReviewApplication.entities.StudentEntity;
import com.Springboot.StudentCoureReviewApplication.repository.CourseRepository;
import com.Springboot.StudentCoureReviewApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
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
    public StudentEntity updateStudent(UpdateStudentDto student) {
        StudentEntity updateStudent = studentRepository.findById(student.getStudentId()).orElse(null);
        if(updateStudent != null){
            updateStudent.setStudentCity(student.getStudentCity());
            updateStudent.setStudentName(student.getStudentName());
            updateStudent.setStudentEmail(student.getStudentEmail());
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
    public int buyCourses(Long studentId,Long courseId) {
        CourseEntity buyCourse = null;
        StudentEntity buyerStudent =null;
        try {
            buyCourse = courseRepository.findById(courseId).get();
            buyerStudent = studentRepository.findById(studentId).get();
            if (buyerStudent != null) {
                if (buyerStudent.getCourseList().contains(buyCourse)) return 11;
                buyerStudent.getCourseList().add(buyCourse);
                buyCourse.getStudentList().add(buyerStudent);
                courseRepository.save(buyCourse);
                studentRepository.save(buyerStudent);
                return 1;
            }
        }finally {
            if (buyCourse == null) return 0;
            if(buyerStudent ==null) return 2;
        }
        return  10 ;
    }
}
