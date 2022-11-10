package com.Springboot.StudentCoureReviewApplication.repository;

import com.Springboot.StudentCoureReviewApplication.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
}
