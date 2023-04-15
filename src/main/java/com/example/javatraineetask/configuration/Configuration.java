package com.example.javatraineetask.configuration;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="configuration")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title")
    private String title;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name="upload_date")
    private LocalDate uploadDate;

    @Column(name = "author")
    private int author;

    @Column(name = "description")
    private String description;

    public Configuration(){

    };

    public Configuration(String title, LocalDate uploadDate, int author, String description){
        this.title = title;
        this.uploadDate = uploadDate;
        this.author = author;
        this.description = description;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString(){
        return "User [id - " + id + ", Title - " + title + ", Uploaded at - " + uploadDate + ", Author - " + author +
                ", Description" + description + ";";
    }
}
