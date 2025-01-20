// File: src/com/childlibrary/model/Author.java
package com.childlibrary.model;

public class Author {
    private int id;
    private String firstName;
    private String lastName;
    private String biography;

    public Author() {}

    public Author(String firstName, String lastName, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
    }

    public Author(int id, String firstName, String lastName, String biography) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
    }

    // Геттеры и сеттеры

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getBiography() {
        return biography;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
