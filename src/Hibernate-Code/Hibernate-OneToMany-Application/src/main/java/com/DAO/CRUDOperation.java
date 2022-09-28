package com.DAO;

import java.io.IOException;

public interface CRUDOperation {
    void insertData() throws IOException;
    void fetchData();
    void deleteData() throws IOException;
    void updateData();
}
