package com.DAO;

import java.io.IOException;

public interface EmployeeDAO {
    void insertData() throws IOException;
    void deleteData() throws IOException;
    void fetchData();
    void updateData() throws IOException;
    void fetchBasedOnCondition();
    void sortBasedOnCondition();
}
