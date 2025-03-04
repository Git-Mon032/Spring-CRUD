package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity // Marks this class as a database entity
@Table(name = "users") // Sets the table name in the database
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    @Column(nullable = false) // Ensures name cannot be null
    private String name;
    
    @Column(unique = true)
    private String email;
    
    private int age;
    
    @CreationTimestamp
    private LocalDateTime createdAt;

    // Default Constructor (Required by JPA)
    public User() {}

    // Constructor with parameters
    public User(String name) {
        this.name = name;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    
    protected void onCreate() {
    	createdAt = LocalDateTime.now();
    }
}
