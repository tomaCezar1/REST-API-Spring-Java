package com.example.lab5.project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Book {

    private long id;
    private String name;
    private String author;
    private Integer nrPage;

    public Book(long id, String name, String author, Integer nrPage) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.nrPage = nrPage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNrPage() {
        return nrPage;
    }

    public void setNrPage(Integer nrPage) {
        this.nrPage = nrPage;
    }
}
