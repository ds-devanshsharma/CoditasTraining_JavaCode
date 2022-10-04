package com.bean;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)@ColumnDefault("9999")
    private int authorID;
    private String authorName;

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorID=" + authorID +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
