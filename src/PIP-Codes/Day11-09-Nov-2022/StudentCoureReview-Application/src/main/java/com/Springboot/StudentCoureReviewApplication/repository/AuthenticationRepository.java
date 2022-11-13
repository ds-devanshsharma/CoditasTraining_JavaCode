package com.Springboot.StudentCoureReviewApplication.repository;

import com.Springboot.StudentCoureReviewApplication.entities.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<LoginEntity,String> {
}
