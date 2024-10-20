package com.example.libraryManagementSystem.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    
    @Column(unique = true)
    private String email;
    
    private String name;
    
    private int age;
    private String country;
    
    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books_written;
    
    public Author() {}
    
    public Author(String name,String email,int age, String country) {
    	this.name = name;
    	this.age = age;
    	this.email = email;
    	this.country = country;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBooks_written() {
        return books_written;
    }

    public void setBooks_written(List<Book> books_written) {
        this.books_written = books_written;
    }
    
}
