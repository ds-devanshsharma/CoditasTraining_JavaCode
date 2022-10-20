package com.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;
    private String bookName;

    @ManyToMany(cascade = CascadeType.ALL )
    @JoinTable(name ="Book_Author_Table" ,
    joinColumns = @JoinColumn(name = "bookID") ,
    inverseJoinColumns = @JoinColumn(name = "authorID"))
    private List<Author> authorList;

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

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public BookPublication getPublication() {
        return publication;
    }

    public void setPublication(BookPublication publication) {
        this.publication = publication;
    }

    @ManyToOne(cascade = CascadeType.ALL )
    private BookPublication publication ;
}
