package com.DAO;

import com.bean.Book;

import java.io.IOException;
import java.util.List;

public interface BookDAO {

    int insertBook() throws IOException;
    int  deleteBook() throws IOException;
    int updateBook() throws IOException;
    void fetchAll();
    void fetchSpecificBook() throws IOException;
}
