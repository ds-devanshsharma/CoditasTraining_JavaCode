package com.Springboot.StudentCoureReviewApplication.repository;

import com.Springboot.StudentCoureReviewApplication.entities.CourseEntity;
import com.Springboot.StudentCoureReviewApplication.entities.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity,Long> {
    @Query(value = "SELECT * FROM REVIEW_TABLE WHERE STUDENT_ID = ?1" ,nativeQuery = true)
    List<ReviewEntity> getReviewByStudentId(Long studentId);
}
