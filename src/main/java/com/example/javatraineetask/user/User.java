package com.example.javatraineetask.user;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "user_")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nick_name")
    private String nickName;


    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "email")
    private String email;

    @Column(name = "password_")
    private String password;


    public User(){

    }

    public User(String nickName, LocalDate dob, String email, String password){
        this.nickName = nickName;
        this.dob = dob;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "User [id - " + id + ", NickName - " + nickName + ", DoB - " + dob + ", Email - " + email + ", Password"
                + password + ";";
    }
}
