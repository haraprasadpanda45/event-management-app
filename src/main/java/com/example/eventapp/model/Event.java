package com.example.eventapp.model;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String type;
    private LocalDate date;

    @Column(length = 1000)
    private String description;

    // getters & setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}