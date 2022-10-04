package com.service;

import java.io.IOException;

public interface Service {
    void registerTeacher() throws IOException;
    void addTeacherCourses() throws IOException;
    void showTeacherAndTheirCourses() throws IOException;
    void deleteTeacher() throws IOException;
    void deleteCourses();
    void updateCourse();
    void updateTeacher();
}
