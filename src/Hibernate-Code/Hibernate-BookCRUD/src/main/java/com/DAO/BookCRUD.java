package com.DAO;

import com.bean.Book;

import java.util.List;

public interface BookCRUD {
    void insertBook(Book book);
    void fetchBook();
    void fetchBookByID(int id );
    void deleteBook(int id);
    void updateBook(int i,float price);
    void fetchByRestriction(float p);
    void fetchByOrder(String order,String property);
    void fetchByProjection(String property);
}
