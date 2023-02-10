package ru.authorizationapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.authorizationapp.model.Quote;
import ru.authorizationapp.model.User;
import ru.authorizationapp.repository.UserRepository;

import java.util.List;

@Service
public class QuoteService {
    public final UserRepository repository;

    public QuoteService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Quote> allQuotes() {
        return repository.allQuotes();
    }

    public Quote saveQuote(User user, String text) {
        return repository.saveQuote(user, text);
    }

    public Quote randomQuote(){
        return repository.randomQuote();
    }

    public void upvoteQuote(int id){
        repository.upvoteQuote(id);
    }

    public void downvoteQuote(int id){
        repository.downvoteQuote(id);
    }

    public List<Quote> top10(){
        return repository.top10();
    }
}
