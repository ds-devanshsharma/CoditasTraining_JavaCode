package com.service;

public interface SubjectService {
    void addSubjectToStudent();
    void addMarkToSubject(int studentId, int subjectId, int marks);
}
