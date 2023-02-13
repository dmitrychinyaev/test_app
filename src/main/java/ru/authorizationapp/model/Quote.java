package ru.authorizationapp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Quote {
    @NotBlank
    @Size(min = 2, max = 150)
    private String quote;
    private final Date dateOfCreation;

    private Date dateOfUpdate;

    private final String username;

    private final AtomicInteger rating;

    public void setQuote(String quote) {
        this.quote = quote;
        this.dateOfUpdate = new Date();
    }

    public void upvote(){
        rating.getAndIncrement();
    }

    public void downvote(){
        rating.getAndDecrement();
    }

    public String getQuote() {
        return quote;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public Date getDateOfUpdate() {
        return dateOfUpdate;
    }

    public String getUsername() {
        return username;
    }

    public AtomicInteger getRating() {
        return rating;
    }

    public Quote(String quote, String username) {
        this.quote = quote;
        this.dateOfCreation = new Date();
        this.username = username;
        this.rating = new AtomicInteger(0);
    }
}
