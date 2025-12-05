package com.example.todo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class modelo {

    @Id @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime DateBegin;
    private LocalDateTime DateEnd;
    private String owner;

    //Getter y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateBegin() {
        return DateBegin;
    }

    public void setDateBegin(LocalDateTime dateBegin) {
        DateBegin = dateBegin;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        DateEnd = dateEnd;
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}

