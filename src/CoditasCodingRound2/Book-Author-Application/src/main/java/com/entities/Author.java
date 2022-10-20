package com.entities;

import javax.persistence.*;
import java.util.List;
@Entity
public class Author {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorID;
    private String authorName;
    @ManyToMany(cascade = CascadeType.ALL ,mappedBy = "authorList")
    private List<Book> bookList;
}
