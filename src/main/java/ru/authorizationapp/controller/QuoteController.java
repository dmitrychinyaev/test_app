package ru.authorizationapp.controller;

import org.springframework.web.bind.annotation.*;
import ru.authorizationapp.model.Quote;
import ru.authorizationapp.model.User;
import ru.authorizationapp.service.QuoteService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class QuoteController {
    private final QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }
    @GetMapping
    public List<Quote> allQuotes(){
        return service.allQuotes();
    }

    @PostMapping
    public Quote saveQuote(@RequestBody User user, String text){
        return service.saveQuote(user, text);
    }

    @GetMapping("/random")
    public Quote randomQuote(){
        return service.randomQuote();
    }

    @GetMapping("/upvote{id}")
    public void upvoteQuote(@PathVariable int id){
        service.upvoteQuote(id);
    }

    @GetMapping("/downvote{id}")
    public void downvoteQuote(@PathVariable int id){
        service.downvoteQuote(id);
    }

    @GetMapping("/top10")
    public void top10(){
        service.top10();
    }
}
