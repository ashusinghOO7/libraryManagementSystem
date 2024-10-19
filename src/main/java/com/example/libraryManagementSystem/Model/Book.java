package com.example.libraryManagementSystem.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Author author;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Publisher publisher;
    
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean isAvailable;
    
    
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Transaction> transactions;
    
    public Book(){
    	
    }
    
    public Book(String name, Genre genre, Author author) {
    	this.name = name;
    	this.genre = genre;
    	this.author = author;
    }

}
