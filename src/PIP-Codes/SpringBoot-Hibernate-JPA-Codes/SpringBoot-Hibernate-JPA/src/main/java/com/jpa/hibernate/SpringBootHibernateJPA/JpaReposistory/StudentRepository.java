package com.jpa.hibernate.SpringBootHibernateJPA.JpaReposistory;
import com.jpa.hibernate.SpringBootHibernateJPA.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager entityManager;
    /* findById(Long id )
       save(Course course)
       deleteById(Long id)
     */
    public Course findById(Long courseId){
        return entityManager.find(Course.class,courseId);
    }
    public void deleteCourseById(Long courseId){
        entityManager.remove(entityManager.find(Course.class,courseId));
    }
    public void addCourse(Course course){
        entityManager.persist(course);
    }
}
