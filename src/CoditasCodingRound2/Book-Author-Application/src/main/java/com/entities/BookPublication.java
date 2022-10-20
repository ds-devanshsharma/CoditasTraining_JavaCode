package com.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class BookPublication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pub_id;
    private String pubName;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "publication")
    private List<Book> bookList ;

}
