// File: src/com/childlibrary/model/Book.java
package com.childlibrary.model;

public class Book {
    private int id;
    private String title;
    private Author author;
    private Category category;
    private int year;
    private String isbn;

    public Book() {}

    public Book(String title, Author author, Category category, int year, String isbn) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.year = year;
        this.isbn = isbn;
    }

    public Book(int id, String title, Author author, Category category, int year, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.year = year;
        this.isbn = isbn;
    }

    // Геттеры и сеттеры

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setId(int id) {
        this.id = id;
    } 

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
