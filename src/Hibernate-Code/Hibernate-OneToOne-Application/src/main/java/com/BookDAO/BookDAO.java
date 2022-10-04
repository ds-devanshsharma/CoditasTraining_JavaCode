package com.BookDAO;

import com.bean.Book;

import java.io.IOException;

public interface BookDAO {
    void insertBook() throws IOException;
    void fetchAllBook();
    void deleteBook(int bookID);
    void updateBook(int bookID) throws IOException;
    void fetchBookByID(int bookID);
}
