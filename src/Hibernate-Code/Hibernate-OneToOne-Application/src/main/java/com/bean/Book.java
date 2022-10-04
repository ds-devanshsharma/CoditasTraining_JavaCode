package com.bean;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
public class Book {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private int bookID;
    private String bookName;
    private float price;
    @OneToOne@JoinColumn(name = "authorID")
    private Author author;

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public Book() {
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
