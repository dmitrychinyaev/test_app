package ru.authorizationapp.model;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private String name;
    private String password;
    private String email;
    private Date dateCreated;

    private AtomicInteger rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateCreated() {
        return dateCreated;
    }


    public AtomicInteger getRating() {
        return rating;
    }


    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.dateCreated = new Date();
        this.rating = new AtomicInteger(0);
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", dateCreated=" + dateCreated;
    }

}
