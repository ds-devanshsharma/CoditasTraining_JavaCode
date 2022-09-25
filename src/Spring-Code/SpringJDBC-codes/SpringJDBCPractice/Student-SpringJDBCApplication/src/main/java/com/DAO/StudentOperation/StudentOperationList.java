package com.DAO.StudentOperation;

import java.io.IOException;

public interface StudentOperationList {
    void insertStudent() throws IOException;
    void deleteStudent();
    void updateStudent();
    void fetchStudent();
    void fetchStudentBasedOnID();
}
