package ru.authorizationapp.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class User {

    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank
    @Size(min = 5, max = 20)
    private String password;

    @Email
    private String email;

    private Date dateCreated;

    private List<Quote> quoteList = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateCreated() {
        return dateCreated;
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
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", dateCreated=" + dateCreated;
    }

    public Quote makeQuote(String text){
        Quote quote = new Quote(text, getName());
        quoteList.add(quote);
        return quote;
    }

}
