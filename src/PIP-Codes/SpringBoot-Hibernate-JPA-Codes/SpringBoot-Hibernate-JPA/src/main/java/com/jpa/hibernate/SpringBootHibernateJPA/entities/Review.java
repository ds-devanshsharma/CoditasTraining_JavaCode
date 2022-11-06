package com.jpa.hibernate.SpringBootHibernateJPA.entities;
import javax.persistence.*;

@Entity
public class Review {
     @Id
     @GeneratedValue
     private int reviewId;
     @Column(nullable = false)
     private String rating;
     private String description;

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                ", course=" + course +
                '}';
    }
    @ManyToOne
     private Course course;

    public int getReviewId() {
        return reviewId;
    }
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
